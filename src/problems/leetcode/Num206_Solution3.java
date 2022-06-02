package problems.leetcode;

import utils.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 * 反转链表
 * <p>
 * 给你单链表的头节点 head, 请你反转链表, 并返回反转后的链表
 * <p>
 * 提示:
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶: 链表可以选用迭代或递归方式完成反转, 你能否用两种方法解决这道题?
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.Recursion}
 * <p>
 * Solution: {@link questions.tags.Recursion}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n), 其中 n 是链表的长度
 * 需要对链表的每个节点进行反转操作
 * <p>
 * 空间复杂度: O(n), 其中 n 是链表的长度
 * 空间复杂度主要取决于递归调用的栈空间, 最多为 n 层
 */
public class Num206_Solution3 {

    private ListNode newHead;

    public static void main(String[] args) {
        Num206_Solution3 instance = new Num206_Solution3();

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

        // newHead 是新链表的头节点
        return newHead;
    }

    private ListNode reverse(ListNode node) {
        if (node.next != null) {
            ListNode next = reverse(node.next);

            // 反转链表
            next.next = node;

            // 将当前节点的 next 指向 null, 避免链表出现循环引用
            // 除了旧链表的第一个节点外, 当前节点的 next 实际上在递归的上一个方法中赋值
            node.next = null;
        } else {
            // 当 node.next == null, 说明当前已经没有下一个节点了, 当前节点就是新链表的头节点
            newHead = node;
        }
        return node;
    }
}
