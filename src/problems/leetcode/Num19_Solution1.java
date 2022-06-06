package problems.leetcode;

import utils.ListNode;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表, 删除链表的倒数第 n 个结点, 并且返回链表的头结点
 * <p>
 * 示例 1:
 * 输入: head = [1, 2, 3, 4, 5], n = 2
 * 输出: [1, 2, 3, 5]
 * <p>
 * 示例 2:
 * 输入: head = [1], n = 1
 * 输出: []
 * <p>
 * 示例 3:
 * 输入: head = [1, 2], n = 1
 * 输出: [1]
 * <p>
 * 提示:
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶: 尝试使用一趟扫描实现
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(L), 其中 L 是链表的长度
 * <p>
 * 空间复杂度: O(1)
 */
public class Num19_Solution1 {

    public static void main(String[] args) {
        Num19_Solution1 instance = new Num19_Solution1();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println(instance.removeNthFromEnd(head, 2));
    }

    /**
     * 快慢指针法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 由于链表的头节点是有可能被删除的, 设置一个虚拟头节点能够使问题变得更方便解决
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 快指针先走 (n + 1) 步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时慢指针就指向待删除节点的前一个节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
