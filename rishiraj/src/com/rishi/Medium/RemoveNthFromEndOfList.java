package com.rishi.Medium;

import com.rishi.util.ListNode;

public class RemoveNthFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // edge cases
        if(head == null)
            return null;

        // declare 2 pointers of head
        ListNode slow = head;
        ListNode fast = head;

        // move fast pointer till n
        while(n-- > 0){
            if(fast == null)
            {
                System.out.println("Index out of bounds");
                return null;
            }
            fast = fast.next;
        }

        // fast is null then the element need to be deleted is 1st one
        if(fast == null){
            return head.next;
        }

        // move both slow and fast until fast is null
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // now slow is last - n, so delete node
        if(slow.next != null)
            slow.next = slow.next.next;
        return head;
    }
}
