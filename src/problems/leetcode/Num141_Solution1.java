package problems.leetcode;

import utils.ListNode;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * 环形链表
 * <p>
 * 给定一个链表, 判断链表中是否有环
 * <p>
 * 进阶: 尝试使用 O(1) 内存解决此问题
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.TwoPointers}, {@link questions.tags.HashTable}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(N), 其中 N 是链表中的节点数, 最坏情况下我们需要遍历每个节点一次
 * <p>
 * 空间复杂度: O(N), 其中 N 是链表中的节点数
 * 主要为哈希表的开销, 最坏情况下我们需要将每个节点插入到哈希表中一次
 * <p>
 * Reference: https://leetcode.cn/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 */
public class Num141_Solution1 {

    public static void main(String[] args) {
        Num141_Solution1 instance = new Num141_Solution1();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head.next.next;

        System.out.println(instance.hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }

        return false;
    }
}
