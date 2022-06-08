package problems.leetcode;

import utils.ListNode;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * https://leetcode.cn/problems/linked-list-cycle-lcci/
 * 环形链表 II
 * <p>
 * 给定一个链表, 返回链表开始入环的第一个节点
 * 如果链表无环, 则返回 null
 * 不允许修改给定的链表
 * <p>
 * 进阶: 尝试使用 O(1) 空间解决此题
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.TwoPointers}, {@link questions.tags.HashTable}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(N), 其中 N 为链表中节点的数目, 我们恰好需要访问链表中的每一个节点
 * <p>
 * 空间复杂度: O(N), 其中 N 为链表中节点的数目, 我们需要将链表中的每个节点都保存在哈希表当中
 */
public class Num142_Solution1 {

    public static void main(String[] args) {
        Num142_Solution1 instance = new Num142_Solution1();

        // case 1
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head.next.next;

        // case 2
        // ListNode head = new ListNode(1);
        // head.next = head;

        // case 3
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = head;

        System.out.println(instance.detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) {
                // 重复遇到的第一个节点必定就是环的第一个节点
                return head;
            }
            hashSet.add(head);
            head = head.next;
        }

        return null;
    }
}
