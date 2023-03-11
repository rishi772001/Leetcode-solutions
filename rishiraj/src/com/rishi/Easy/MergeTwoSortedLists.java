package com.rishi.Easy;

import com.rishi.util.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        // swap, since l1 is used as answer
        if(l2.val < l1.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        // if l1 has only one element
        if(l1.next == null){
            l1.next = l2;
            return l1;
        }

        // create reference
        ListNode ans = l1;

        while(l1.next != null && l2 != null){
            if(l1.next.val > l2.val){
                // create ref for next value
                ListNode temp = l1.next;

                // update next value with new value
                l1.next = new ListNode(l2.val);

                l1.next.next = temp;
                l2 = l2.next;
            }
            l1 = l1.next;
        }
        if(l2 != null)
            l1.next = l2;
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1};
        int[] arr2 = {};

        ListNode l1 = ListNode.createLinkedList(arr1);
        ListNode l2 = ListNode.createLinkedList(arr2);

        ListNode.printList(new MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}
