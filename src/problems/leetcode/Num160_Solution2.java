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
 * Solution: {@link questions.tags.Iteration}, {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(m + n), 其中 m 和 n 是分别是链表 headA 和 headB 的长度
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Reference: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E9%9D%A2%E8%AF%95%E9%A2%9802.07.%E9%93%BE%E8%A1%A8%E7%9B%B8%E4%BA%A4.md
 */
public class Num160_Solution2 {

    public static void main(String[] args) {
        Num160_Solution2 instance = new Num160_Solution2();

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
     * 如果链表 A 和链表 B 存在相交节点, 那么从两个链表的相交节点开始, 到最后一个节点组成的子链表必定是完全相同的
     * 可以对齐两个链表的尾部, 然后用两个指针分别指向两个子链表的头节点, 同时移动这两个指针
     * 如果两个指针指向的节点是相同的, 说明链表 A 和链表 B 存在相交节点
     * 如果两个指针移动到链表的尾部都没找到相同的节点, 说明链表 A 和链表 B 不存在相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 获取链表 A 和链表 B 的长度
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // 计算差值
        int dif = lengthA - lengthB;

        // 根据差值移动链表 A 或者链表 B, 对齐两个链表的尾部
        if (dif >= 0) {
            for (int i = 0; i < dif; i++) {
                headA = headA.next;
            }
        } else {
            dif = -dif;
            for (int i = 0; i < dif; i++) {
                // 链表 B 的长度大于链表 A
                // 指针 headB 指向了链表 B
                headB = headB.next;
            }
        }

        // 同时移动两个指针, 判断两个指针指向的节点是不是同一个节点
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
