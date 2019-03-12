package tree;

/**
 * 创建 树
 * 主要属性 root 只有获取根节点方法
 *
 * 主要方法
 * 插入
 * 查找
 * 遍历
 *
 */
public class BinaryTree {

 private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 向树中插入数据
     * @param value
     */
    public void insert(int value){

        TreeNode newNode = new TreeNode(value);
        //插入数据时判断是否是根节点插入
        if(root == null){
            root = newNode;
            root.setLeft(null);
            root.setRight(null);
        }else{
            // 不是根节点插入，获取根节点作为当前节点
            TreeNode currentNode = root;
            TreeNode parentNode;

            //循环插入，直到找到叶子节点，将新值插入
            while(true){
                //将根节点赋值给父节点
                parentNode = currentNode;

                if(newNode.getValue() > currentNode.getValue()) {
                    currentNode = currentNode.getRight();

                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                }else{
                    currentNode = currentNode.getLeft();

                    if(currentNode == null){
                        parentNode.setLeft(newNode);
                        return;
                    }
                }

            }

        }
    }


    /**
     * 查找
     *
     * @param value
     * @return
     */
    public TreeNode find(int value){

        //获取根节点作为当前节点
        TreeNode currentNode = root;
        //根节点不为null
        if(root != null){
            while (currentNode.getValue() != value){
                if(value > currentNode.getValue()){
                    currentNode = currentNode.getRight();
                }else{
                    currentNode = currentNode.getLeft();
                }

                if(currentNode == null){
                    return null;
                }

            }
            if(currentNode.getDeleteStatus()){
                return null;
            }else{
                return currentNode;
            }

        }else{

            return null;

        }


    }


    /**
     * 中序遍历
     * @return
     */
    public void inOrder(TreeNode root){

        if(root != null){
            inOrder(root.getLeft());
            System.out.println(root.getValue());
            inOrder(root.getRight());

        }


    }


    /**
     * 前序遍历
     * @return
     */
    public void preOrder(TreeNode root){

        if(root != null){
            System.out.println(root.getValue());
            preOrder(root.getLeft());
            preOrder(root.getRight());

        }


    }
    /**
     * 后序遍历
     * @return
     */
    public void postOrder(TreeNode root){

        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getValue());

        }


    }



}
