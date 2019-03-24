package tree;

import tree.定义二叉树.BinaryTree;

/**
 *
 *          10
 *     3          20
 *        5    15     30
 *                        45
 *                            123
 *
 *
 */
public class TreeTest {

public static void main(String[] args){

    BinaryTree binaryTree = new BinaryTree();
    binaryTree.insert(10);
    binaryTree.insert(3);
    binaryTree.insert(5);
    binaryTree.insert(20);
    binaryTree.insert(30);
    binaryTree.insert(15);
    binaryTree.insert(45);
    binaryTree.insert(123);

    TreeNode root = binaryTree.getRoot();
    System.out.println("跟节点是"+root.getValue());

    TreeNode treeNode = binaryTree.find(5);
    if(treeNode != null){
        System.out.println("找到了");
    }else{
        System.out.println("没找到");
    }

    System.out.println("===前序====");

    binaryTree.preOrder(root);

    System.out.println("===中序====");

    binaryTree.inOrder(root);

    System.out.println("===后序====");

    binaryTree.postOrder(root);

}

}
