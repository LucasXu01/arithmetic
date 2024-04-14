package org.example;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // 前序遍历
    public void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " "); // 访问根节点
            preorderTraversal(node.left); // 遍历左子树
            preorderTraversal(node.right); // 遍历右子树
        }
    }

    // 中序遍历
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left); // 遍历左子树
            System.out.print(node.val + " "); // 访问根节点
            inorderTraversal(node.right); // 遍历右子树
        }
    }

    // 后序遍历
    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left); // 遍历左子树
            postorderTraversal(node.right); // 遍历右子树
            System.out.print(node.val + " "); // 访问根节点
        }
    }
}


public class 前序中序后序二叉树 {
    public static void main(String[] args) {

    }
}
