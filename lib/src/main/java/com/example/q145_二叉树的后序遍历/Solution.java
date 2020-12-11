package com.example.q145_二叉树的后序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归法 o(n)
 */
public class Solution {
    /**
     * 后序遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> rs = new LinkedList<>();
        if (root == null) {
            return rs;
        }
        stack.push(root);

        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            //往头部add，先把root add进去       1
            rs.addFirst(temp.val);
            //栈，先入后出，left后出  left right root         3
            if (temp.left != null) {
                stack.push(temp.left);
            }
            //right ，先出  right root         2
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return rs;
    }

    /**
     * 前序遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                rs.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //根 左已经遍历了，再遍历右即可
            root = stack.pop();
            root = root.right;
        }
        return rs;
    }

    /**
     * 中序遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            rs.add(root.val);
            root = root.right;
        }
        return rs;
    }

    /**
     * 递归法
     * 二叉树前序遍历   根-> 左-> 右
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);
    }
}
