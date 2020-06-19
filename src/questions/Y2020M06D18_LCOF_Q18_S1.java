package questions;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点
 * 返回删除后的链表的头节点
 *
 * 说明:
 * 题目保证链表中节点的值互不相同
 */
public class Y2020M06D18_LCOF_Q18_S1 {

    public static void main(String args[]) {
        Y2020M06D18_LCOF_Q18_S1 instance = new Y2020M06D18_LCOF_Q18_S1();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(instance.deleteNode(head, 5));
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode temp = header;
        ListNode pre;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
            if (val == temp.val) {
                pre.next = temp.next;
                break;
            }
        }
        return header.next;
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
