package tree;

/**
 * 定义节点类型
 * 主要属性： value 值  left 左节点   right 右节点
 *
 */

public class TreeNode {
    //关键值
     int value;
    //左子树
     TreeNode left;
    //右子树
     TreeNode right;
    //删除状态
    private Boolean deleteStatus;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this(value,null,null,false);
    }

    public TreeNode(int value, TreeNode left, TreeNode right, Boolean deleteStatus) {
        this.value = value;
        this.left = left;
        this.left = right;
        this.deleteStatus = deleteStatus;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }


    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                ", deleteStatus=" + deleteStatus +
                '}';
    }
}
