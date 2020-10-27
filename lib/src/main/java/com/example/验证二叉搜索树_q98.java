package com.example;

/**
 * @author xumingqiang@keepreal.group
 * @description 二叉搜索树
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @date 2020/10/26 6:34 PM
 */
public class 验证二叉搜索树_q98 {
    long pre = Long.MIN_VALUE;

    /**
     * 二叉树 中根遍历，左-根-右，是有序的，若无序则异常。
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
