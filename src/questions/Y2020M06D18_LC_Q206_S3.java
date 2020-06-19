package questions;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 反转链表
 */
public class Y2020M06D18_LC_Q206_S3 {

    private ListNode header;

    public static void main(String args[]) {
        Y2020M06D18_LC_Q206_S3 instance = new Y2020M06D18_LC_Q206_S3();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        reverse(head);
        return header;
    }

    private ListNode reverse(ListNode node) {
        if (node.next != null) {
            ListNode pre = reverse(node.next);
            pre.next = node;
            node.next = null;
        } else {
            header = node;
        }
        return node;
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
