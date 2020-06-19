package questions;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Y2020M06D19_LC_Q160_S2 {

    public static void main(String args[]) {
        Y2020M06D19_LC_Q160_S2 instance = new Y2020M06D19_LC_Q160_S2();
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
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        boolean endA = false;
        boolean endB = false;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                break;
            }
            if (p1.next == null && !endA) {
                p1 = headB;
                endA = true;
            } else {
                p1 = p1.next;
            }
            if (p2.next == null && !endB) {
                p2 = headA;
                endB = true;
            } else {
                p2 = p2.next;
            }
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
