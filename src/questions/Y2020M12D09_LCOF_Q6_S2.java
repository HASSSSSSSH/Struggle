package questions;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * <p>
 * 从尾到头打印链表
 * 输入一个链表的头节点, 从尾到头反过来返回每个节点的值 (用数组返回)
 * <p>
 * Tags: {@link questions.tags.LinkedList}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n), 辅助栈 stack 和数组 ans 共使用 O(n) 的额外空间
 */
public class Y2020M12D09_LCOF_Q6_S2 {

    public static void main(String args[]) {
        Y2020M12D09_LCOF_Q6_S2 instance = new Y2020M12D09_LCOF_Q6_S2();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println(Arrays.toString(instance.reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pollLast();
        }
        return ans;
    }
}
