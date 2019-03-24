package tree.二叉树深度;

import tree.TreeNode;

/**
 * 二叉树深度
 *
 */
public class TreeDeep {

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(25);
        TreeNode treeNode3 = new TreeNode(35);
        TreeNode treeNode4 = new TreeNode(45);
        TreeNode treeNode5 = new TreeNode(55);
        TreeNode treeNode6 = new TreeNode(65);
        TreeNode treeNode7 = new TreeNode(75);

        treeNode2.setLeft(treeNode7);
        treeNode3.setLeft(treeNode2);
        treeNode3.setRight(treeNode1);
        treeNode5.setLeft(treeNode4);
        treeNode5.setRight(treeNode6);
        treeNode.setLeft(treeNode3);
        treeNode.setRight(treeNode5);

        System.out.println(findTreeDepth(treeNode));
        System.out.println(findTreeDepth(treeNode3));

    }

    /**
     * 查找树的深度
     *
     * @param treeNode
     */
    private static int findTreeDepth(TreeNode treeNode) {
        //当找到叶子节点时返回 0
        if(treeNode == null){
            return 0;
        }

        //查找左子树的深度
        int left = findTreeDepth(treeNode.getLeft()) + 1;

        int right = findTreeDepth(treeNode.getRight()) + 1;

        return Math.max(left,right);


    }


}
