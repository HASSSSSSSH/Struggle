package questions;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */
public class Y2020M06D18_LCOF_Q22_S1 {

    public static void main(String args[]) {
        Y2020M06D18_LCOF_Q22_S1 instance = new Y2020M06D18_LCOF_Q22_S1();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.getKthFromEnd(head, 4));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (k - 1 > 0 && p2 != null) {
            p2 = p2.next;
            k--;
        }
        while (p2 != null && p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
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
                        .append("\n");
                head = head.next;
            }
            return builder.toString();
        }
    }
}
