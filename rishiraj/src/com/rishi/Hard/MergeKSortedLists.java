package com.rishi.Hard;

import com.rishi.Easy.MergeTwoSortedLists;
import com.rishi.util.ListNode;

public class MergeKSortedLists {
    private static ListNode divide(ListNode[] lists, int start, int end){
        if(start == end)
            return lists[start];
        if(start == end - 1)
            return new MergeTwoSortedLists().mergeTwoLists(lists[start], lists[end]);

        int mid = (start + end) / 2;
        return new MergeTwoSortedLists().mergeTwoLists(divide(lists, start, mid), divide(lists, mid + 1, end));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return divide(lists, 0, lists.length - 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {1, 3, 4};

        ListNode l1 = ListNode.createLinkedList(arr1);
        ListNode l2 = ListNode.createLinkedList(arr2);

        ListNode.printList(new MergeKSortedLists().mergeKLists(new ListNode[]{l1, l2}));
    }
}
