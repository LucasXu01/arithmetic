public class leetcode_link {

    /**
     * 单链表类题
     */
    public static void main(String[] args) {
        // head = [1,2,3,4,5], k = 2
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        myprint(listNode1);
        ListNode answer = new Solution().reverseKGroup(listNode1,2);
//        ListNode answer = new Solution().reverseKStep2(listNode1,2);
//        ListNode answer = new Solution().reverseBetweenLink(listNode1,1,3);
//        ListNode answer = new Solution().reverse2(listNode1,5);
//        ListNode answer = new Solution().reverseLink2(listNode1);
//        ListNode answer = new Solution().reverseBetweenLink(listNode1, 1,3);

        myprint(answer);


    }

    public static void myprint(ListNode answer) {
        System.out.println(answer.val);
        System.out.println(answer.next.val);
        System.out.println(answer.next.next.val);
        System.out.println(answer.next.next.next.val);
        System.out.println(answer.next.next.next.next.val);
    }
}


class Solution {

    public static void myprint2(ListNode answer) {
        System.out.print("     ");
        System.out.print(answer.val);
        System.out.print(answer.next.val);
        System.out.print(answer.next.next.val);
        System.out.print(answer.next.next.next.val);
        System.out.print(answer.next.next.next.next.val);
    }


    /**
     * 单链表 中的 K 步长翻转
     * 1 2 3 4 5  k=2  =>  2 1 4 3 5
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode pre2 = head;


        int length = 0;
        while (pre2 != null) {
            length++;
            pre2 = pre2.next;
        }

        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
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


    /**
     * 单链表 中的 start - end 位置的链表 倒序
     * 1 2 3 4 5  start=1; end=3;  =>  1 4 3 2 5
     *
     * @param head
     * @param start
     * @param end
     * @return
     */
    public ListNode reverseBetweenLink(ListNode head, int start, int end) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
//        head = dummy.next;

        for (int i = 0; i < start; i++) {
            pre = pre.next;
            head = pre.next;
        }

        for (int j = start; j < end; j++) {
            ListNode nxt = head.next;
            head.next = nxt.next;
            nxt.next = pre.next;
            pre.next = nxt;
        }

        return dummy.next;
    }

    /**
     * 单链表倒序
     * 1 2 3 4 5 = > 5 4 3 2 1
     *
     * @param head
     * @return
     */
    public ListNode reverseLink(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (head.next != null) {

            ListNode nxt = head.next;
            head.next = nxt.next;
            nxt.next = dummy.next;
            dummy.next = nxt;

            myprint2(dummy.next);
        }
        return dummy.next;
    }





    public ListNode reverseKStep(ListNode head, int step){
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode dummy2 = dummy;

        int length = 0;

        while (dummy2.next!= null){
            length ++;
            dummy2 = dummy2.next;
        }

        System.out.println(length+" --- ----- -- - --- -- - - --");

        for (int i = 0 ; i < length/step ; i ++){
            for (int j = 0 ; j < step -1; j ++){
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

    public ListNode reverseKStep2(ListNode head, int step){
       ListNode dummy = new ListNode();
       dummy.next = head;

        ListNode temp = dummy;
        ListNode pre = dummy;

        int length = 0;

        while (temp.next!=null){
            length++;
            temp = temp.next;
        }

        for(int i=0; i < length/step; i++){
            for(int j=0; j<step-1; j++){
                ListNode nxt = head.next;

                head.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;

            }

            pre = head;
            head = pre.next;
        }

        return dummy.next;


    }


    public ListNode testReverse(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        if (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }




}

