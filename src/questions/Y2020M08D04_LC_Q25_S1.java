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
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
public class Y2020M08D04_LC_Q25_S1 {

    public static void main(String args[]) {
        Y2020M08D04_LC_Q25_S1 instance = new Y2020M08D04_LC_Q25_S1();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.reverseKGroup(head, 4));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        int count = 0;
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode res = header;

        ListNode preNode = null;
        ListNode next = head;
        while (next != null) {
            // reverse
            ListNode temp = next.next;
            next.next = preNode;
            preNode = next;
            next = temp;

            count++;
            if (count == k) {
                // point to new head
                header.next = preNode;

                count = 0;
                while (header.next != null) {
                    // 重设header的位置
                    header = header.next;
                }
                preNode = null;
            }
        }
        if (count > 0) {
            // 将不满足k的整数倍的全部节点再次反转, 恢复原状
            next = preNode;
            preNode = null;
            while (next != null) {
                // reverse
                ListNode temp = next.next;
                next.next = preNode;
                preNode = next;
                next = temp;
            }
            // point to new head
            header.next = preNode;
        }
        return res.next;
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
            Y2020M08D04_LC_Q25_S1.ListNode head = this;
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
