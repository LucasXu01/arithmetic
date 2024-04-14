package org.example;

public class FindAncestorNode {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空或等于其中一个目标节点，则返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归地查找左子树和右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树的结果都不为空，则当前节点是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 如果左子树的结果不为空，而右子树的结果为空，则最近公共祖先在左子树中
        if (left != null) {
            return left;
        }

        // 如果右子树的结果不为空，而左子树的结果为空，则最近公共祖先在右子树中
        return right;
    }
}
