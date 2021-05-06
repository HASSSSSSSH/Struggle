package questions;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Solution: {@link questions.tags.Recursive}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n), 系统递归需要使用 O(n) 的栈空间
 */
public class Y2020M12D09_LCOF_Q6_S1 {

    public static void main(String args[]) {
        Y2020M12D09_LCOF_Q6_S1 instance = new Y2020M12D09_LCOF_Q6_S1();

        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        System.out.println(Arrays.toString(instance.reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reversePrint(list, head);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void reversePrint(List<Integer> list, ListNode head) {
        if (head != null) {
            reversePrint(list, head.next);
            list.add(head.val);
        }
    }
}
