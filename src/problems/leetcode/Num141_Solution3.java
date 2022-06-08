package problems.leetcode;

import utils.ListNode;

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
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(N), 其中 N 是链表中的节点数
 * 当链表中不存在环时, 快指针将先于慢指针到达链表尾部, 链表中每个节点至多被访问两次
 * 当链表中存在环时, 每一轮移动后, 快慢指针的距离将减小 1, 而初始距离为环的长度, 因此至多移动 N 轮
 * <p>
 * 空间复杂度: O(1), 我们只使用了两个指针的额外空间
 * <p>
 * Reference: https://leetcode.cn/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 */
public class Num141_Solution3 {

    public static void main(String[] args) {
        Num141_Solution3 instance = new Num141_Solution3();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head.next.next;

        System.out.println(instance.hasCycle(head));
    }

    /**
     * 类似于 {@link Num141_Solution2} 的解法
     */
    public boolean hasCycle(ListNode head) {
        // 由于接下来使用的是 do-while 循环, 因此可以将快慢指针的初始值都置为 head
        ListNode fast = head;
        ListNode slow = head;

        do {
            // 如果快指针最终将指向空值 null, 那么链表不是环形链表
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        // 当 do-while 循环结束, 说明当前已满足 fast == slow, 快指针与慢指针相遇, 链表是环形链表
        return true;
    }
}
