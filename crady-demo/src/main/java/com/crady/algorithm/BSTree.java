package com.crady.algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author :Crady
 * date :2020/04/12 22:50
 * desc : 实现了二叉查找树的：先序遍历、中序遍历、后序遍历、层次遍历
 **/
public class BSTree {

    public static void main(String[] args){
        Node root = initBSTree(10);
//        前序遍历：1-2-4-8-9-5-10-3-6-7
//        中序遍历：8-4-9-2-10-5-1-6-3-7
//        后序遍历：8-9-4-10-5-2-6-7-3-1
//        层次遍历：1-2-3-4-5-6-7-8-9-10

//        System.out.println("*****************前序遍历(递归实现)*********************");
//        preOrder(root);
//          System.out.println("*****************前序遍历(非递归实现)*********************");
//          preOrder2(root);

//        System.out.println("*****************中序遍历*********************");
//        midOrder(root);
//          System.out.println("*****************中序遍历(非递归实现)*********************");
//          midOrder2(root);

//        System.out.println("*****************后序遍历*********************");
//        afterOrder(root);
//          System.out.println("*****************后序遍历(非递归实现)*********************");
//          afterOrder2(root);
          System.out.println("*****************层次遍历*********************");
          levelOrder(root);
    }

    /**
     * 二叉查找树-前序遍历(递归实现)
     * @param node
     */
    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二叉查找树-前序遍历(非递归实现)
     * @param node
     */
    public static void preOrder2(Node node){
        if(node == null)return;
        Stack<Node> s = new Stack<>();
        Node tmp = node;
        while(tmp != null || !s.isEmpty()){
            while(tmp != null){
                System.out.println(tmp);
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.isEmpty()){
                Node n = s.pop();
                tmp = n.right;
            }
        }
    }

    /**
     * 二叉查找树-中序遍历(递归实现)
     * @param node
     */
    public static void midOrder(Node node){
        if(node == null){
            return;
        }
        midOrder(node.left);
        System.out.println(node);
        midOrder(node.right);
    }

    /**
     * 二叉查找树-中序遍历(非递归实现)
     * @param node
     */
    public static void midOrder2(Node node){
        if(node == null){
            return;
        }
        Stack<Node> s = new Stack<>();
        Node tmp = node;
        while(tmp != null || !s.isEmpty()){
            while(tmp != null){
                s.push(tmp);
                tmp = tmp.left;
            }
            if(!s.isEmpty()){
                Node n = s.pop();
                System.out.println(n);
                tmp = n.right;
            }
        }
    }

    /**
     * 二叉查找树-后序遍历(递归实现)
     * @param node
     */
    public static void afterOrder(Node node){
        if(node == null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node);
    }

    /**
     * 二叉查找树-后序遍历(非递归实现)
     * @param node
     */
    public static void afterOrder2(Node node){
        if(node == null)return;
        Stack<Node> s1 = new Stack<>();
        //n2记录是从左子节点还是右子节点返回父节点的，左节点返回1，右节点返回2
        Stack<Integer> s2 = new Stack<>();
        while(node != null || !s1.isEmpty()){
            while(node != null){
                s1.push(node);
                s2.push(1);
                node = node.left;
            }
            while(!s2.isEmpty() && s2.peek() == 2){
                s2.pop();
                System.out.println(s1.pop());
            }
            if(!s2.isEmpty() && s2.peek() == 1){
                s2.pop();
                s2.push(2);
                node = s1.peek().right;
            }
        }
    }
    /**
     * 二叉查找树-层次遍历(非递归实现)
     * @param node
     */
    public static void levelOrder(Node node){
        if(node == null)return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(node);
        Node tmp;
        while(!list.isEmpty()){
            tmp = list.poll();
            System.out.println(tmp);
            if(tmp.left != null){
                list.add(tmp.left);
            }
            if(tmp.right != null){
                list.add(tmp.right);
            }
        }
    }


    public static Node initBSTree(int n){
        Node [] ns = new Node[n];
        for (int i = 0; i < n; i++) {
            ns[i] = new Node();
            ns[i].val = i + 1;
        }
        for (int i = 0; i < n; i++) {
            if(2*i+1 < n){
                ns[i].left = ns[2*i+1];
            }
            if(2*i+2 < n){
                ns[i].right = ns[2*i+2];
            }
        }
        return ns[0];
    }

    static class Node{
        int val;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
//                    ", left=" + left +
//                    ", right=" + right +
                    '}';
        }
    }

}
