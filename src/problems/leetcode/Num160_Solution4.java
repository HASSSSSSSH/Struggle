package problems.leetcode;

import utils.ListNode;

import java.util.HashSet;

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
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(m + n), 其中 m 和 n 是分别是链表 headA 和 headB 的长度, 需要遍历两个链表各一次
 * <p>
 * 空间复杂度: O(m), 其中 m 是链表 headA 的长度, 需要使用哈希集合存储链表 headA 中的全部节点
 * <p>
 * Reference: https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
 */
public class Num160_Solution4 {

    public static void main(String[] args) {
        Num160_Solution4 instance = new Num160_Solution4();

        ListNode headA = new ListNode(1);
        ListNode tempA = headA;
        for (int i = 2; i <= 5; i++) {
            tempA.next = new ListNode(i);
            tempA = tempA.next;
        }
        ListNode headB = new ListNode(0);
        headB.next = new ListNode(0);
        headB.next.next = headA.next.next.next;

        System.out.println(instance.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();

        ListNode temp = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }
}
