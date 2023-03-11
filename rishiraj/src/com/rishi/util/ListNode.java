package com.rishi.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkedList(int[] arr){
        ListNode head = null;
        ListNode ref = null;
        for(int i : arr){
            // first element
            if(head == null){
                head = new ListNode(i);
                ref = head;
            } else {
                head.next = new ListNode(i);
                head = head.next;
            }
        }
        return ref;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = ListNode.createLinkedList(arr);
        printList(head);
    }
}

