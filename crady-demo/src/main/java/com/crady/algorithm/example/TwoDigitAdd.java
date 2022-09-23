package com.crady.algorithm.example;

/**
 * @author :Crady
 * date :2022/06/25 00:49
 * desc :给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class TwoDigitAdd {

    public static void main(String[] args) {

        ListNode a4 = new ListNode(9);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(4, a3);
        ListNode a = new ListNode(2, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(6, b3);
        ListNode b = new ListNode(5, b2);

        long start = System.currentTimeMillis();
        printListNode(twoDigitAdd(a,b));
        System.out.println("finish, cost : " + (System.currentTimeMillis() - start) + " ms");

    }

    public static ListNode twoDigitAdd (ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode tmp = new ListNode();
        ListNode listNode = tmp;
        int nextAdd = 0;
        while (a != null) {
            int n = a.val;
            a = a.next;
            if (b != null) {
                n += b.val;
                b = b.next;
            }

            n += nextAdd;
            nextAdd = 0;
            nextAdd = n / 10;
            int value = n % 10;

            ListNode ln = new ListNode(value);
            tmp.next = ln;
            tmp = ln;
        }
        listNode = listNode.next;
        // 走到这里说明b长度比a长，需要加上b剩下的元素
        while (b != null) {
            int n = b.val;

            n += nextAdd;
            nextAdd = n / 10;
            int value = n % 10;

            ListNode ln = new ListNode(value);
            tmp.next = ln;
            tmp = ln;
            b = b.next;
        }

        if (nextAdd > 0) {
            ListNode ln = new ListNode(nextAdd);
            tmp.next = ln;
            tmp = ln;
        }

        return listNode;
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        StringBuffer res = new StringBuffer(""+listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            res.append(",").append(listNode.val);
        }
        System.out.println(res);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /****方法二(推荐)******/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode n1 = l1;
        ListNode n2 = l2;
        int s = 0;
        ListNode pre = null;
        while (n1 != null || n2 != null) {

            if (n1 != null && n2 != null) {
                int add = n1.val + n2.val;
                add += s;
                ListNode nd = new ListNode();
                nd.val = add % 10;
                s = add / 10;
                if(pre != null) {
                    pre.next = nd;
                }else {
                    res = nd;
                }
                pre = nd;
                n1 = n1.next;
                n2 = n2.next;
                continue;
            }
            if (n1 != null) {
                ListNode nd = new ListNode();
                int add = n1.val + s;
                nd.val = add % 10;
                s = add / 10;
                pre.next = nd;
                pre = nd;
                n1 = n1.next;
            }
            if (n2 != null) {
                ListNode nd = new ListNode();
                int add = n2.val + s;
                nd.val = add % 10;
                s = add / 10;
                pre.next = nd;
                pre = nd;
                n2 = n2.next;
            }
        }
        if(s > 0) {
            ListNode nd = new ListNode();
            nd.val = s;
            pre.next = nd;
        }

        return res;
    }

    public ListNode reverseList(ListNode node){
        ListNode head = null;
        ListNode nd = node;
        while (nd != null) {
            ListNode next = nd.next;
            nd.next = head;
            head = nd;
            nd = next;
        }
        return head;
    }
}
