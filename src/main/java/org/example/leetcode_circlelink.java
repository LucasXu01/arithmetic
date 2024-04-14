public class leetcode_circlelink {
    public static void main(String[] args) {

    }

    //判断下环的长度
    public int cycleLength(ListNode head) {
        if (!hasCycle(head)) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        int length = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            length = length + 1;
        }
        return length;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            try{
                slow = slow.next;
                fast = fast.next.next;
            }catch (Exception e){
                return false;
            }
            if (slow == fast)
                return true;
        }
    }



    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        // 使用快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            // fast一趟两次，slow一趟一次
            if(fast.next == slow || fast.next.next == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }







}
