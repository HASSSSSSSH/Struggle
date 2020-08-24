package questions;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回
 * 新链表是通过拼接给定的两个链表的所有节点组成的
 * <p>
 * Solution: Recursive
 * <p>
 * 时间复杂度: O(n + m), 其中 n 和 m 分别为两个链表的长度
 * 因为每次调用递归都会去掉 l1 或者 l2 的头节点, 直到至少有一个链表为空
 * 函数 mergeTwoList 至多只会递归调用每个节点一次
 * 因此, 时间复杂度取决于合并后的链表长度, 即 O(n + m)
 * <p>
 * 空间复杂度: O(n + m), 其中 n 和 m 分别为两个链表的长度
 * 递归调用 mergeTwoLists 函数时需要消耗栈空间, 栈空间的大小取决于递归调用的深度
 * 结束递归调用时 mergeTwoLists 函数最多调用 n + m 次, 因此空间复杂度为 O(n + m)
 */
public class Y2020M08D012_LC_Q21_S2 {

    public static void main(String args[]) {
        Y2020M08D012_LC_Q21_S2 instance = new Y2020M08D012_LC_Q21_S2();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(6);
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(5);
        System.out.println(instance.mergeTwoLists(head1, head2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Y2020M08D012_LC_Q21_S2.ListNode head = this;
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
