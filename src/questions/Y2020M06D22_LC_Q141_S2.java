package questions;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * Solution: Fast & Slow Pointer
 * <p>
 * Reference: https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(N), 其中 N 是链表中的节点数, 最坏情况下我们需要遍历每个节点一次
 * 当链表中不存在环时, 快指针将先于慢指针到达链表尾部, 链表中每个节点至多被访问两次
 * 当链表中存在环时, 每一轮移动后, 快慢指针的距离将减小 1 , 而初始距离为环的长度, 因此至多移动 N 轮
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M06D22_LC_Q141_S2 {

    public static void main(String args[]) {
        Y2020M06D22_LC_Q141_S2 instance = new Y2020M06D22_LC_Q141_S2();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head.next.next;
        System.out.println(instance.hasCycle(head));
    }

    // 错误的解法
    // (ListNode fast = head.next; ListNode slow = head;) 并不是预先设想的快指针走两步, 慢指针走一步
    // public boolean hasCycle(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return false;
    //     }
    //     ListNode fast = head.next;
    //     ListNode slow = head;
    //     while (fast != slow && fast.next != null && fast.next.next != null) {
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //     return fast == slow;
    // }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 不存在 slow 和 fast 同时为null的情况
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
