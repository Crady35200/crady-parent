package com.crady.cache;

import java.util.HashMap;

/**
 * @author: Crady
 * date: 2022/7/22 00:32
 * desc:
 **/
public class LRUCache {

    private Node head, tail;
    private HashMap<String, Node> cache;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        initLinkNode();
    }

    public Object get(String key) {
        Node node = cache.get(key);
        if (node != null) {
            changeAfterUpdate(node);
        }
        return node.value;
    }

    public void put(String key, Object value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            changeAfterUpdate(node);
            return;
        }
        if (size >= capacity) {
            cache.remove(tail.pre.key);
            deleteNode(tail.pre);
        }
        node = new Node();
        node.key = key;
        node.value = value;
        addToHead(node);
        cache.put(node.key, node);
        size++;
        System.out.println(size + "=" + cache.size());
    }

    private void changeAfterUpdate(Node node) {
        deleteNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }


    private void deleteNode(Node node) {
        if (node != head && head != tail){
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
    }

    private void initLinkNode() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }


    static class Node {
        public Node pre;
        public Node next;
        public String key;
        public Object value;

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("1","one");
        lruCache.put("2","two");
        lruCache.put("3","three");
        lruCache.put("4","four");
        lruCache.put("5","five");
        // 5,4,3,2,1
        lruCache.put("6","six");
        // 6,5,4,3,2
        lruCache.put("5","555five");
        // 5,6,4,3,2
        lruCache.get("4");
        // 4,5,6,3,2
        System.out.println(lruCache);
        lruCache.printLinkNode(lruCache.head);
    }

    private void printLinkNode(Node node) {
        while (node.next != null) {
            node = node.next;
            System.out.println(node.key + "=" + node.value);
        }
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
