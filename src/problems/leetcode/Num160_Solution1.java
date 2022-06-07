package problems.leetcode;

import utils.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * 相交链表
 * <p>
 * 给你两个单链表的头节点 headA 和 headB, 请你找出并返回两个单链表相交的起始节点
 * 如果两个链表不存在相交节点, 返回 null
 * 题目数据 保证 整个链式结构中不存在环
 * 注意, 函数返回结果后, 链表必须 保持其原始结构
 * <p>
 * 提示:
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点, intersectVal 为 0
 * 如果 listA 和 listB 有交点, intersectVal == listA[skipA] == listB[skipB]
 * <p>
 * 进阶: 尝试设计一个时间复杂度 O(m + n), 仅用 O(1) 内存的解决方案
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.TwoPointers}, {@link questions.tags.HashTable}
 * <p>
 * Solution: {@link questions.tags.BruteForce}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(m * n), 其中 m 和 n 是分别是链表 headA 和 headB 的长度
 * <p>
 * 空间复杂度: O(1)
 */
public class Num160_Solution1 {

    public static void main(String[] args) {
        Num160_Solution1 instance = new Num160_Solution1();

        ListNode headA = new ListNode(1);
        ListNode tempA = headA;
        for (int i = 2; i <= 5; i++) {
            tempA.next = new ListNode(i);
            tempA = tempA.next;
        }
        ListNode headB = new ListNode(0);
        headB.next = new ListNode(0);
        headB.next.next = headA.next.next;

        System.out.println(instance.getIntersectionNode(headA, headB));
    }

    /**
     * 暴力法
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB;
        outer:
        while (tempA != null) {
            tempB = headB;
            while (tempB != null) {
                if (tempA == tempB) {
                    break outer;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return tempA;
    }
}
