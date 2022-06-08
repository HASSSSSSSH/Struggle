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
public class Num141_Solution2 {

    public static void main(String[] args) {
        Num141_Solution2 instance = new Num141_Solution2();

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
     * 快慢指针法
     * <p>
     * 定义两个指针, 一快一慢, 慢指针每次只移动一步, 而快指针每次移动两步
     * 初始时, 慢指针在位置 head, 快指针也在位置 head, 同时移动两个指针
     * <p>
     * 如果链表是环形链表, 假设环的长度为 l, 当慢指针处于环的开始节点时, 快指针也必定处于环中的某一节点, 慢指针与快指针的最大距离为 l
     * 在两个指针的移动过程中, 由于快指针每次移动两步, 而慢指针每次只移动一步, 两指针的距离会逐渐减 1, 最后快指针会反过来追上慢指针
     * <p>
     * 如果链表不是环形链表, 那么快指针最终将指向空值 null
     */
    public boolean hasCycle(ListNode head) {
        // 这里的初始判断是必须的
        // 判断 (head == null) 可以避免语句 ListNode fast = head.next 出现空指针异常
        // 判断 (head.next == null) 可以避免语句 if (fast.next == null || fast.next.next == null) 出现空指针异常
        if (head == null || head.next == null) {
            return false;
        }

        // 将快指针初始化为 head.next 是为了使语句 while (fast != slow) 不会出现误判
        ListNode fast = head.next;

        ListNode slow = head;

        while (fast != slow) {
            // 如果快指针最终将指向空值 null, 那么链表不是环形链表
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            // 快指针移动两步
            fast = fast.next.next;

            // 慢指针移动一步
            // 这里不需要判空, 原因是如果链表不是环形链表, 那么快指针会比慢指针更快指向空值, 然后循环就结束了
            slow = slow.next;
        }

        // 当 while 循环结束, 说明当前已满足 fast == slow, 快指针与慢指针相遇, 链表是环形链表
        return true;
    }
}
