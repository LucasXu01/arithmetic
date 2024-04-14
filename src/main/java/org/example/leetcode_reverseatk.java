public class leetcode_reverseatk {
    public static void main(String[] args) {

    }

    /**
     * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/comments/
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode frontNode = head;
        ListNode behindNode = head;

        while (frontNode != null && k > 0) {
            frontNode = frontNode.next;
            k--;
        }

        while (frontNode != null) {
            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }

}
