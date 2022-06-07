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
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(m + n), 其中 m 和 n 是分别是链表 headA 和 headB 的长度
 * 两个指针同时遍历两个链表, 每个指针遍历两个链表各一次
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Reference: https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
 */
public class Num160_Solution3 {

    public static void main(String[] args) {
        Num160_Solution3 instance = new Num160_Solution3();

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

    /**
     * 当链表 headA 和 headB 都不为空时, 创建两个指针 pA 和 pB
     * 令 pA 和 pB 分别指向两个链表的头节点 headA 和 headB, 然后将两个指针依次遍历两个链表的每个节点
     * 具体做法如下:
     * 每步操作需要同时更新指针 pA 和 pB
     * 如果指针 pA 不为空, 则将指针 pA 移到下一个节点; 如果指针 pB 不为空, 则将指针 pB 移到下一个节点
     * 如果指针 pA 为空, 则将指针 pA 移到链表 headB 的头节点; 如果指针 pB 为空, 则将指针 pB 移到链表 headA 的头节点
     * 当指针 pA 和 pB 指向同一个节点时, 返回该节点; 当指针 pA 和 pB 都指向空值 null 时, 返回 null
     * <p>
     * 下面提供双指针方法的正确性证明
     * 考虑两种情况, 第一种情况是两个链表相交, 第二种情况是两个链表不相交
     * <p>
     * 情况一: 两个链表相交
     * 链表 headA 和 headB 的长度分别是 m 和 n
     * 假设链表 headA 的不相交部分有 a 个节点, 链表 headB 的不相交部分有 b 个节点, 两个链表相交的部分有 c 个节点, 则有 a + c = m, b + c = n
     * <p>
     * 如果 a = b, 则两个指针会同时到达两个链表相交的节点, 此时返回相交的节点
     * <p>
     * 如果 a != b, 则指针 pA 会遍历完链表 headA, 指针 pB 会遍历完链表 headB, 两个指针不会同时到达链表的尾节点
     * 然后指针 pA 移到链表 headB 的头节点, 指针 pB 移到链表 headA 的头节点, 两个指针继续移动
     * 在指针 pA 移动了 a + c + b 次且指针 pB 移动了 b + c + a 次之后, 两个指针会同时到达两个链表相交的节点
     * 该节点也是两个指针第一次同时指向的节点, 此时返回相交的节点
     * <p>
     * 情况二: 两个链表不相交
     * 链表 headA 和 headB 的长度分别是 m 和 n
     * 考虑当 m = n 和 m != n 时, 两个指针分别会如何移动:
     * <p>
     * 如果 m = n, 则两个指针会同时到达两个链表的尾节点, 然后同时变成空值 null, 此时返回 null
     * <p>
     * 如果 m != n, 两个指针都会遍历完两个链表, 在指针 pA 移动了 m + n 次且指针 pB 移动了 n + m 次之后, 两个指针会同时变成空值 null, 此时返回 null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }
        return pA;
    }
}
