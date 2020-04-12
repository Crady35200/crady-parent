package com.crady.algorithm;

/**
 * @author :Crady
 * date :2020/04/10 23:48
 * desc : 单链表翻转
 **/
public class LinkListReverse {

    public static void main(String[] args) {
        Node n = init();
        print(n);
        n = reverse(n);
        System.out.println("***********************翻转后***********************");
        print(n);

    }

    public static void print(Node node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 反转单链表
     * @param node
     * @return
     */
    public static Node reverse(Node node){
        //定义一个零时头结点作为反转后的头结点
        Node t = new Node();
        Node next;
        while(node != null){
            next = node.next;
            node.next = t.next;
            t.next = node;
            node = next;
        }
        return t.next;
    }

    public static Node init(){
        Node head = new Node("head");
        Node tmp = head;
        Node n;
        for (int i = 0; i < 10; i++) {
            n = new Node("val-" + i);
            tmp.next = n;
            tmp = n;
        }
        return head;
    }

    static class Node{
        String val;
        Node next;
        public Node(){
        }
        public Node(String val){
            this.val = val;
        }

    }

}
