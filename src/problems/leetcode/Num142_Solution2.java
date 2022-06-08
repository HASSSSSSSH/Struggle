package problems.leetcode;

import utils.ListNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * https://leetcode.cn/problems/linked-list-cycle-lcci/
 * 环形链表 II
 * <p>
 * 给定一个链表, 返回链表开始入环的第一个节点
 * 如果链表无环, 则返回 null
 * 说明: 不允许修改给定的链表
 * <p>
 * 进阶: 尝试使用 O(1) 空间解决此题
 * <p>
 * Tags: {@link questions.tags.LinkedList}, {@link questions.tags.TwoPointers}, {@link questions.tags.HashTable}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(N), 其中 N 为链表中节点的数目
 * 在最初判断快慢指针是否相遇时, slow 指针走过的距离不会超过链表的总长度
 * 随后寻找入环点时, 走过的距离也不会超过链表的总长度
 * 因此, 总的执行时间为 O(N) + O(N) = O(N)
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Reference:
 * https://leetcode.cn/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.md
 */
public class Num142_Solution2 {

    public static void main(String[] args) {
        Num142_Solution2 instance = new Num142_Solution2();

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
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        ListNode temp = head;
        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }

        return slow;
    }
}
