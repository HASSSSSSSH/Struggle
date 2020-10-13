package questions;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 环形链表 II
 * 给定一个链表, 返回链表开始入环的第一个节点, 如果链表无环, 则返回 null
 * 为了表示给定链表中的环, 我们使用整数 pos 来表示链表尾连接到链表中的位置(索引从 0 开始)
 * 如果 pos 是 -1, 则在该链表中没有环
 * 注意, pos 仅仅是用于标识环的情况, 并不会作为参数传递到函数中
 * <p>
 * 说明: 不允许修改给定的链表
 * <p>
 * 进阶: 你是否可以使用 O(1) 空间解决此题?
 * <p>
 * Solution: Fast & Slow Pointer
 * <p>
 * Reference: https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(N), 其中 N 为链表中节点的数目
 * 在最初判断快慢指针是否相遇时, slow 指针走过的距离不会超过链表的总长度
 * 随后寻找入环点时, 走过的距离也不会超过链表的总长度
 * 因此, 总的执行时间为 O(N) + O(N) = O(N)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M10D13_LC_Q142_S1 {

    public static void main(String args[]) {
        Y2020M10D13_LC_Q142_S1 instance = new Y2020M10D13_LC_Q142_S1();
        // 1
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = head.next.next;

        // 2
        // ListNode head = new ListNode(1);
        // head.next = head;

        // 3
        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = head;

        System.out.println(instance.detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "node-" + this.hashCode() + ": " + this.val;
        }
    }
}
