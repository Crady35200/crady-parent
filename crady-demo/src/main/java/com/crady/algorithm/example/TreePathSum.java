package com.crady.algorithm.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Crady
 * date: 2022/9/22 16:41
 * desc: 二叉树每个节点都是一个整数，获取所有从根节点到叶子节点的数字组成的一个数字的和。
 * 比如：
 *      1
 *    2   3
 *  4  5
 *
 *  则有三条路径1-2-4，1-2-5，1-3 组成的三个数组124,125，,13，这三个数之和就是262
 *
 **/
public class TreePathSum {

    private static int sum = 0;

    public static void main(String[] args) {
        calSum(initTreeNode(),new ArrayList<>());
        System.out.println(sum);
        exec(initTreeNode());
        System.out.println(total);
    }

    public static void calSum(TreeNode root, List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list);
        newList.add(root.value);
        if (root.left != null) {
            calSum(root.left,newList);
        }
        if (root.right != null) {
            calSum(root.right,newList);
        }
        if (root.right == null && root.left == null) {
            sum += getListSum(newList);
        }
    }

    public static int getListSum(List<Integer> integers) {
        int sum = 0;
        for(int i=0; i<integers.size();i++) {
            sum = sum * 10 + integers.get(i);
        }
        return sum;
    }

    public static TreeNode initTreeNode() {
        // 124+125+13=262
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(root, 2);
        TreeNode rightNode = new TreeNode(root, 3);
        root.left = leftNode;
        root.right = rightNode;
        TreeNode subLeftNode = new TreeNode(leftNode, 4);
        TreeNode subRightNode = new TreeNode(leftNode, 5);
        leftNode.left = subLeftNode;
        leftNode.right = subRightNode;
        return root;
    }

    static class TreeNode {
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode(int value){
            this.value = value;
        }
        public TreeNode(TreeNode parent, int value) {
            this.parent = parent;
            this.value = value;
        }
    }

    static int total =0;
    static List<Integer> list = new ArrayList<>();
    public static void exec(TreeNode root){
        if(root == null) {
            return;
        }
        list.add(root.value);
        if(root.left == null && root.right == null) {
            System.out.println(list);
            int n = 0;
            for (int i = 0; i < list.size(); i++) {
                total += list.get(i) * Math.pow(10,list.size() - i - 1);
            }
        }
        exec(root.left);
        exec(root.right);
        list.remove(list.size() - 1);
    }

}
