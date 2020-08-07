package questions;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * K 个一组翻转链表
 * 给你一个链表, 每 k 个节点一组进行翻转, 请你返回翻转后的链表
 * k 是一个正整数, 它的值小于或等于链表的长度
 * 如果节点总数不是 k 的整数倍, 那么请将最后剩余的节点保持原有顺序
 * <p>
 * 示例:
 * 给你这个链表: 1->2->3->4->5
 * 当 k = 2 时, 应当返回: 2->1->4->3->5
 * 当 k = 3 时, 应当返回: 3->2->1->4->5
 * <p>
 * 说明:
 * 你的算法只能使用常数的额外空间
 * 你不能只是单纯的改变节点内部的值, 而是需要实际进行节点交换
 * <p>
 * Solution: Iterative
 * Reference: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 * 时间复杂度: (???) 时间复杂度为 O(n * k), 最好的情况为 O(n), 最坏的情况为 O(n^2)
 * 空间复杂度: O(1)
 */
public class Y2020M08D05_LC_Q25_S3 {

    public static void main(String args[]) {
        Y2020M08D05_LC_Q25_S3 instance = new Y2020M08D05_LC_Q25_S3();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.reverseKGroup(head, 0));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode hair = dummy;
        ListNode start = head;
        ListNode end = start;
        int count = 0;
        while (end != null) {
            ++count;
            if (count == k) {
                ListNode temp = end.next;
                end.next = null;
                hair.next = reverse(start);
                start.next = temp;

                hair = start;
                start = temp;
                end = start;
                count = 0;
                continue;
            }
            end = end.next;
        }
        return dummy.next;
    }

    /**
     * 时间复杂度: 时间复杂度为 O(k), 最好的情况为 O(1), 最坏的情况为 O(n)
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Y2020M08D05_LC_Q25_S3.ListNode head = this;
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
