package questions;

import utils.ListNode;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 两数相加 II
 * <p>
 * 给你两个 非空 链表来代表两个非负整数
 * 数字最高位位于链表开始位置, 它们的每个节点只存储一位数字, 将这两数相加会返回一个新的链表
 * 你可以假设除了数字 0 之外, 这两个数字都不会以零开头
 * <p>
 * 进阶:
 * 如果输入链表不能修改该如何处理? 换句话说, 你不能对列表中的节点进行翻转
 * <p>
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * Tags: {@link questions.tags.LinkedList}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * Solution: {@link questions.tags.Stack}
 * <p>
 * 时间复杂度: O(max(m, n)), 其中 m 与 n 分别为两个链表的长度, 我们需要遍历每个链表
 * <p>
 * 空间复杂度: O(m + n), 其中 m 与 n 分别为两个链表的长度, 这是我们把链表内容放入栈中所用的空间
 */
public class Y2021M01D06_LC_Q445_S2 {

    public static void main(String args[]) {
        Y2021M01D06_LC_Q445_S2 instance = new Y2021M01D06_LC_Q445_S2();

        // ListNode list1 = new ListNode(7);
        // list1.next = new ListNode(2);
        // list1.next.next = new ListNode(4);
        // list1.next.next.next = new ListNode(3);
        // ListNode list2 = new ListNode(5);
        // list2.next = new ListNode(6);
        // list2.next.next = new ListNode(4);

        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(9);
        list1.next.next = new ListNode(9);
        ListNode list2 = new ListNode(1);

        System.out.println(instance.addTwoNumbers(list1, list2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        ListNode temp = l1;
        while (temp != null) {
            stack1.offerLast(temp.val);
            temp = temp.next;
        }

        temp = l2;
        while (temp != null) {
            stack2.offerLast(temp.val);
            temp = temp.next;
        }

        ListNode head = null;
        int carry = 0;
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            int sum = 0;
            sum += stack1.isEmpty() ? 0 : stack1.pollLast();
            sum += stack2.isEmpty() ? 0 : stack2.pollLast();
            sum += carry;

            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }

        return head;
    }
}
