package questions;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Y2020M06D19_LC_Q160_S3 {

    public static void main(String args[]) {
        Y2020M06D19_LC_Q160_S3 instance = new Y2020M06D19_LC_Q160_S3();
        ListNode headA = new ListNode(1);
        ListNode tempA = headA;
        for (int i = 2; i <= 5; i++) {
            tempA.next = new ListNode(i);
            tempA = tempA.next;
        }
        ListNode headB = new ListNode(0);
        headB.next = new ListNode(0);
        headB.next.next = headA.next.next.next;
        System.out.println(instance.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            ListNode head = this;
            while (head != null) {
                builder.append("node-")
                        .append(head.hashCode())
                        .append(": ")
                        .append(head.val)
                        .append(" \n");
                head = head.next;
            }
            return builder.toString();
        }
    }
}
