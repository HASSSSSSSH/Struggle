package questions;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 反转链表
 * 反转一个单链表
 * <p>
 * Solution: Recursive
 * Reference: https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 * <p>
 * 时间复杂度: O(n), 假设 n 是列表的长度, 那么时间复杂度为 O(n)
 * <p>
 * 空间复杂度: O(1), 由于使用递归, 将会使用隐式栈空间, 递归深度可能会达到 n 层
 */
public class Y2020M06D18_LC_Q206_S4 {

    public static void main(String args[]) {
        Y2020M06D18_LC_Q206_S4 instance = new Y2020M06D18_LC_Q206_S4();
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
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
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
