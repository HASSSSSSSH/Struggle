package problems.leetcode;

import utils.ListNode;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 移除链表元素
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val, 请你删除链表中所有满足 Node.val == val 的节点, 并返回 新的头节点
 * <p>
 * 示例 1:
 * 输入: head = [1, 2, 6, 3, 4, 5, 6], val = 6
 * 输出: [1, 2, 3, 4, 5]
 * <p>
 * 示例 2:
 * 输入: head = [], val = 1
 * 输出: []
 * <p>
 * 示例 3:
 * 输入: head = [7, 7, 7, 7], val = 7
 * 输出: []
 * <p>
 * 提示:
 * 列表中的节点数目在范围 [0, 10^4] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.Recursion}
 * <p>
 * Solution: {@link questions.tags.Iteration}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * 时间复杂度: O(n), 其中 n 是链表的长度, 需要遍历链表一次
 * <p>
 * 空间复杂度: O(1)
 */
public class Num203_Solution1 {

    public static void main(String[] args) {
        Num203_Solution1 instance = new Num203_Solution1();

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(6);
        // head.next.next.next = new ListNode(3);
        // head.next.next.next.next = new ListNode(4);
        // head.next.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next.next = new ListNode(6);

        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);

        System.out.println(instance.removeElements(head, 7));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 设置一个虚拟头节点, 能够方便地返回结果
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 在新链表中, preNode 用于表示当前节点 head 的前一个节点
        ListNode preNode = dummyHead;

        // 遍历链表
        while (head != null) {
            if (head.val == val) {
                // 当节点 head 满足 head.val == val 时, 直接从链表中删除当前节点
                preNode.next = head.next;
            } else {
                // 更新 preNode
                preNode = head;
            }
            // 接着进行下一个节点的判断
            head = head.next;
        }

        // dummyHead.next 就是新链表
        return dummyHead.next;
    }
}
