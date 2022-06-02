package problems.leetcode;

import utils.ListNode;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * 两两交换链表中的节点
 * <p>
 * 给你一个链表, 两两交换其中相邻的节点, 并返回交换后链表的头节点
 * 你必须在不修改节点内部的值的情况下完成本题 (只能进行节点交换)
 * <p>
 * 示例 1:
 * 输入: head = [1, 2, 3, 4]
 * 输出: [2, 1, 4, 3]
 * <p>
 * 示例 2:
 * 输入: head = []
 * 输出: []
 * <p>
 * 示例 3:
 * 输入: head = [1]
 * 输出: [1]
 * <p>
 * 提示:
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.Recursion}
 * <p>
 * Solution: {@link questions.tags.Recursion}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n), 其中 n 是链表的节点数量, 需要对每个节点进行更新指针的操作
 * <p>
 * 空间复杂度: O(n), 其中 n 是链表的节点数量, 空间复杂度主要取决于递归调用的栈空间
 */
public class Num24_Solution2 {

    public static void main(String[] args) {
        Num24_Solution2 instance = new Num24_Solution2();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println(instance.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return recurse(head);
    }

    private ListNode recurse(ListNode head) {
        ListNode node2 = head.next;

        if (node2.next != null && node2.next.next != null) {
            head.next = recurse(node2.next);
        } else {
            head.next = node2.next;
        }

        node2.next = head;
        return node2;
    }
}
