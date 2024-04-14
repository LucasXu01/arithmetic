package org.example;

import java.util.*;

//之字形遍历tree
public class questionthree {
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        // 构造函数
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        List<List<Integer>> res = new ArrayList<>();
        res = pri(root);
        for(int i = 0; i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//把根节点放进队列，开始程序
        boolean flag = true;  //控制列表是顺序还是逆序的标志

        while(!queue.isEmpty()){ //如果队列不是空的，说明二叉树不会遍历完，如果有下一层，会在当前这层往队列里加入下一层的节点
            int size = queue.size(); //首先得到当前要这一层要处理的节点数
            List<Integer> curlevel = new ArrayList<>(); //初始化用来放当前这层节点的值的容器
            while(--size >= 0){  //按照要处理节点的个数来处理
                TreeNode cur = queue.remove();  //每处理一个节点，就把一个节点移出队列
                curlevel.add(cur.val);  //同时把要处理节点的值放进当前层的容器中
                if(cur.left != null) queue.add(cur.left);  //如果当前节点有左右子节点，就加入到队列中
                if(cur.right != null) queue.add(cur.right);
            }
            if(flag == false) {  //如果标志位false，将列表逆序
                Collections.reverse(curlevel);
            }
            ans.add(curlevel);
            flag = !flag;  //下一层，flag取反
        }

        return ans;
    }

    public static List<List<Integer>> pri(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = false;

        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                TreeNode nodeTemp = queue.remove();
                cur.add(nodeTemp.val);
                if (nodeTemp.left!=null) queue.add(nodeTemp.left);
                if (nodeTemp.right!=null) queue.add(nodeTemp.right);
                size --;
            }

            if (flag) {
                Collections.reverse(cur);
            }
            flag = !flag;

            list.add(cur);

        }

        return list;

    }
}

