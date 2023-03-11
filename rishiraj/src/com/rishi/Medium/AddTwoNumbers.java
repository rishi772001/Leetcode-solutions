package com.rishi.Medium;

import com.rishi.util.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode out = null;
        ListNode outref = null;

        boolean flag = true;

        while(l1 != null && l2 != null)
        {
            int temp = l1.val + l2.val + carry;
            carry = temp / 10;


            if(flag){
                out = new ListNode(temp % 10);
                flag = false;
                outref = out;
            } else {
                out.next = new ListNode(temp % 10);
                out = out.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null)
        {
            int temp = l1.val + carry;
            carry = temp / 10;

            if(flag) {
                out = new ListNode(temp % 10);
                flag = false;
                outref = out;
            } else {
                out.next = new ListNode(temp % 10);
                out = out.next;
            }
            l1 = l1.next;
        }

        while(l2 != null)
        {
            int temp = l2.val + carry;
            carry = temp / 10;

            if(flag) {
                out = new ListNode(temp % 10);
                flag = false;
                outref = out;
            } else {
                out.next = new ListNode(temp % 10);
                out = out.next;
            }
            l2 = l2.next;
        }

        while(carry > 0)
        {
            out.next = new ListNode(carry % 10);
            out = out.next;
            carry = carry / 10;
        }

        return outref;
    }
}
