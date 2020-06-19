package questions;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class Y2020M06D19_LC_Q160_S1 {

    public static void main(String args[]) {
        Y2020M06D19_LC_Q160_S1 instance = new Y2020M06D19_LC_Q160_S1();
        ListNode headA = new ListNode(1);
        ListNode tempA = headA;
        for (int i = 2; i <= 5; i++) {
            tempA.next = new ListNode(i);
            tempA = tempA.next;
        }
        ListNode headB = new ListNode(0);
        headB.next = new ListNode(0);
        headB.next.next = headA.next.next;
        System.out.println(instance.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB;
        outer:
        while (tempA != null) {
            tempB = headB;
            while (tempB != null) {
                if (tempA == tempB) {
                    break outer;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return tempA;
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
