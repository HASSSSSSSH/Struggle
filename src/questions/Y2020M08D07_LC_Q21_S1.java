package questions;

import utils.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回
 * 新链表是通过拼接给定的两个链表的所有节点组成的
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.Recursion}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(n + m), 其中 n 和 m 分别为两个链表的长度
 * 因为每次循环迭代中, l1 和 l2 只有一个元素会被放进合并链表中
 * 因此 while 循环的次数不会超过两个链表的长度之和
 * 所有其他操作的时间复杂度都是常数级别的
 * 因此总的时间复杂度为 O(n + m)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M08D07_LC_Q21_S1 {

    public static void main(String args[]) {
        Y2020M08D07_LC_Q21_S1 instance = new Y2020M08D07_LC_Q21_S1();
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
        }
        ListNode header = new ListNode();
        ListNode pre = header;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return header.next;
    }
}
