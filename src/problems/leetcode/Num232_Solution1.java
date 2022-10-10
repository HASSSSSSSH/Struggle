package problems.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用栈实现队列
 * <p>
 * 请你仅使用两个栈实现先入先出队列
 * 队列应当支持一般队列的支持的所有操作 (push, pop, peek, empty)
 * 实现 MyQueue 类:
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空, 返回 true, 否则, 返回 false
 * <p>
 * 说明:
 * 你只能使用标准的栈操作, 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的
 * 你所使用的语言也许不支持栈, 你可以使用 list 或者 deque (双端队列) 来模拟一个栈, 只要是标准的栈操作即可
 * <p>
 * Tags: {@link questions.tags.Stack}, {@link questions.tags.Queue}, {@link questions.tags.Design}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Stack}
 * <p>
 * 时间复杂度: push 和 empty 为 O(1), pop 和 peek 为均摊 O(1)
 * 对于每个元素, 至多入栈和出栈各两次, 故均摊复杂度为 O(1)
 * <p>
 * 空间复杂度: O(n), 其中 n 是操作总数
 * 对于有 n 次 push 操作的情况, 队列中会有 n 个元素, 故空间复杂度为 O(n)
 */
public class Num232_Solution1 {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.empty());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    static class MyQueue {
        Deque<Integer> inStack = new ArrayDeque<>();
        Deque<Integer> outStack = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.isEmpty() ? -1 : outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.isEmpty() ? -1 : outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }
}
