package tree.二叉树镜像;

import tree.TreeNode;

/**
 * 通过一个杉树，输入二叉树，返回它的镜像
 *
 * 思路：
 * 前序遍历，再交换左右节点
 *
 *
 */
public class ExchangeTreeNode {

    public static void main(String[] args){
        TreeNode node = new TreeNode(2);
        exchangeNode(node);

    }

    private static void exchangeNode(TreeNode node) {

        if(node != null){
           TreeNode temp =  node.getLeft();
           node.setLeft(node.getRight());
           node.setRight(temp);
            exchangeNode(node.getLeft());
            exchangeNode(node.getRight());
        }
    }

}
