package tree.重建二叉树;

import tree.TreeNode;

import java.util.Arrays;

/**
 * 重建二叉树
 * 给一个树的前序遍历和中序遍历,把这个树重新创建
 * 前序遍历 1,2,4,7,3,5,6,8
 * 中序遍历 4,7,2,1,5,3,8,6
 * <p>
 * 思路：
 * 前序遍历第一个节点是根节点
 * 中序遍历根节点前是左子树，根节点后是右子树
 * <p>
 * 采用数组的 Arrays.copyOfRange() 方法 左闭右开
 */
public class RebuildTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = rebuildTree(pre, in);
        inOrder(treeNode);
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    private static void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeft());
            System.out.println(treeNode.getValue());
            inOrder(treeNode.getRight());
        }
    }
    /**
     * @param pre
     * @param in
     * @return
     */
    private static TreeNode rebuildTree(int[] pre, int[] in) {
        //判断数组不为空
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        // 创建根树 前序遍历第一个是根节点
        TreeNode treeNode = new TreeNode(pre[0]);
        //遍历中序数组 找出根节点下标
        for (int i = 0; i < in.length; i++) {
            //跟节点下标
            if (pre[0] == in[i]) {
                //设置左子树  参数为 树的前序遍历数组左子树下标为 1,i 中序遍历数组 0,i
                treeNode.setLeft(rebuildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i)));
                //设置右子树  参数为 树的前序遍历数组左子树下标为 i+1,data.length 中序遍历数组 0,i
                treeNode.setRight(rebuildTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length)));
            }
        }
        return treeNode;
    }


}
