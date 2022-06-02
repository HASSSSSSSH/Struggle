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
 * <p>
 * Reference: https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 */
public class Num206_Solution4 {

    public static void main(String[] args) {
        Num206_Solution4 instance = new Num206_Solution4();

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

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
