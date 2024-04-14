package org.example;

public class kreverse {


    public static void main(String[] args) {

    }

    public ListNode kReverse(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;


        // 算出总长度
        int l = 0;
        ListNode pre2 = dummy;
        while (pre2.next != null) {
            l++;
            pre2 = pre2.next;
        }

        // K步反转
        for (int i = 0 ; i < l/k; i ++) {
            for (int j = 0 ; j < k-1; j++) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }

            pre = head;
            head = pre.next;
        }

        return dummy.next;

    }
}
