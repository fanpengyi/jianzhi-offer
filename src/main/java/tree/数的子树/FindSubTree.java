package tree.数的子树;

import tree.TreeNode;

/**
 * 给定两棵树 A B 判断B是否是A的子树
 * 算法思路：
 * 先对 A 树进行遍历，找到与B树的根节点值相同的节点R
 * 判断 A 树中以R为根节点的子树是否包含B树一样的结构
 * 注意判断 浮点数相等时不能用 == 判断，应该判断在误差范围内即可
 */
public class FindSubTree {

   public boolean hasSubTree(TreeNode root1, TreeNode root2){
       if(root1 == null || root2 == null){
           return false;
       }
       //判断是树的子节点
       return isSubTree(root1,root2) || hasSubTree(root1.getLeft(),root2) || hasSubTree(root1.getRight(),root2);
   }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        //root2为空返回true
        if(root2 == null){
            return true;
        }
        //root1为空返回false 因为判断的是 root1中包含root2
        if(root1 == null){
            return false;
        }

        //如果都不为空则比较当前节点值
        if(equal(root1.getValue(),root2.getValue())){
            return isSubTree(root1.getLeft(),root2.getLeft()) && isSubTree(root1.getRight(),root2.getRight());
        }else{
            return false;
        }
   }

    /**
     * 浮点数存在精度问题 不能直接用 == 判断是否相等
     * @param num1
     * @param num2
     * @return
     */
   public boolean equal(double num1,double num2){
       if(num1 - num2 > 0.0000001 || num2 - num1 < 0.0000001 ){
           return true;
       }
       return  false;

   }

}
