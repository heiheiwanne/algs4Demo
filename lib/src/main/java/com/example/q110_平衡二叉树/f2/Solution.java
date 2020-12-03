package com.example.q110_平衡二叉树.f2;

/**
 * 从底至顶遍历 o(n)
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    /**
     * 判断对称二叉树
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        /*
        思路：首先根结点以及其左右子树，左子树的左子树和右子树的右子树相同，
        左子树的右子树，和右子树的左子树相同。我们采用递归的方式
        */
        if(pRoot == null){
            return false;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    public static boolean comRoot(TreeNode left, TreeNode right){
        if(left == null){
            return right == null;
        }
        if(right == null){
            return false;//能执行到这一步，说明他的左子树肯定是不为空，此时比较右子树如果为空，那么肯定返回false
        }
        if(left.val != right.val){
            return false;
        }
        //能执行到这一步，说明其传进来的左子树和右子树不为null，且对应值相等，此时我们只需要，进行递归比较
        //传进来的左子树的左子树和传进来右子树的右子树。传进来的左子树的右子树和传进来的右子树的左子树。
        return comRoot(left.left, right.right) && comRoot(left.right, right.left);
    }
}
