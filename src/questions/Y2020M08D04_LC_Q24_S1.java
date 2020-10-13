package questions;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * K 个一组翻转链表
 * 给定一个链表, 两两交换其中相邻的节点, 并返回交换后的链表
 * <p>
 * 示例:
 * 给你这个链表: 1->2->3->4->5
 * 应当返回: 2->1->4->3->5
 * <p>
 * Solution: Iterative
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M08D04_LC_Q24_S1 {

    public static void main(String args[]) {
        Y2020M08D04_LC_Q24_S1 instance = new Y2020M08D04_LC_Q24_S1();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode dummy = header;
        while (dummy.next != null && dummy.next.next != null) {
            ListNode temp = dummy.next.next;
            dummy.next.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
            dummy = temp.next;
        }
        return header.next;
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
