package problems.leetcode;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

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
 * Solution: {@link questions.tags.Stack}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(L), 其中 L 是链表的长度
 * <p>
 * 空间复杂度: O(L), 其中 L 是链表的长度, 主要为栈的开销
 */
public class Num19_Solution3 {

    public static void main(String[] args) {
        Num19_Solution3 instance = new Num19_Solution3();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println(instance.removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = dummyHead;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        for (int i = 1; i <= n; i++) {
            stack.pop();
        }

        // 此时 prev 指向待删除节点的前一个节点
        ListNode prev = stack.peek();

        // prev.next = prev.next.next;
        Objects.requireNonNull(prev).next = prev.next.next;

        return dummyHead.next;
    }
}
