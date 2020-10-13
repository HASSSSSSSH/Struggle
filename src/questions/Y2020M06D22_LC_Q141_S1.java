package questions;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * Solution: Hash Table
 * <p>
 * Reference: https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(N), 其中 N 是链表中的节点数, 最坏情况下我们需要遍历每个节点一次
 * <p>
 * 空间复杂度: O(N), 其中 N 是链表中的节点数
 * 主要为哈希表的开销, 最坏情况下我们需要将每个节点插入到哈希表中一次
 */
public class Y2020M06D22_LC_Q141_S1 {

    public static void main(String args[]) {
        Y2020M06D22_LC_Q141_S1 instance = new Y2020M06D22_LC_Q141_S1();
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
        if (head == null || head.next == null) {
            return false;
        }
        HashMap<ListNode, Object> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, null);
            head = head.next;
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
