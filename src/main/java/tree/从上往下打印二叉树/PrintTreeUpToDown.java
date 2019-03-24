package tree.从上往下打印二叉树;

import tree.BinaryTree;
import tree.TreeNode;

import java.util.LinkedList;

/**
 * 给一个二叉树，要求从上往下分层打印二叉树
 * 使用前序遍历 放在队列中 先进先出
 * 重点： 队列 定义分层变量
 *
 *
 */
public class PrintTreeUpToDown {
    public static void main(String[] args){

        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(25);
        TreeNode treeNode3 = new TreeNode(35);
        TreeNode treeNode4 = new TreeNode(45);
        TreeNode treeNode5 = new TreeNode(55);
        TreeNode treeNode6 = new TreeNode(65);

        treeNode3.setLeft(treeNode2);
        treeNode3.setRight(treeNode1);
        treeNode5.setLeft(treeNode4);
        treeNode5.setRight(treeNode6);
        treeNode.setLeft(treeNode3);
        treeNode.setRight(treeNode5);
        printUpToDown(treeNode);
        
        
    }

    private static void printUpToDown(TreeNode root) {
        if(root == null){
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //设置分层打印参数 用于遍历
        int index = 0;
        //用于计数
        int count = 1;

         while(queue.size() != 0){
             //用于遍历
             index = count;
             //用于计数
             count = 0;
             for (int i = 0; i < index ; i++) {
                 TreeNode poll = queue.poll();
                 System.out.print(poll.getValue() +"\t");
                 if(poll.getLeft() != null){
                     queue.offer(poll.getLeft());
                     count ++ ;
                 }

                 if(poll.getRight() != null){
                     queue.offer(poll.getRight());
                     count ++;
                 }
             }
             System.out.println();
         }
    }

}
