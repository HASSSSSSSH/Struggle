package questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 * 用队列实现栈
 * <p>
 * 请你仅使用队列实现一个后入先出 (LIFO) 的栈, 并支持普通队列的全部四种操作 (push, top, pop 和 empty)
 * <p>
 * 实现 MyStack 类:
 * void push(int x) 将元素 x 压入栈顶
 * int pop() 移除并返回栈顶元素
 * int top() 返回栈顶元素
 * boolean empty() 如果栈是空的, 返回 true, 否则, 返回 false
 * <p>
 * 注意:
 * 你只能使用队列的基本操作 -- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的
 * 你所使用的语言也许不支持队列, 你可以使用 list 或者 deque (双端队列) 来模拟一个队列, 只要是标准的队列操作即可
 * 你可以假设所有操作都是有效的 (例如, 对一个空的栈不会调用 pop 或者 top 操作)
 * <p>
 * Tags: {@link questions.tags.Stack}, {@link questions.tags.Design}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Queue}
 * <p>
 * Reference: https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/
 * <p>
 * 时间复杂度: 入栈操作 O(n), 其余操作都是 O(1)
 * 入栈操作需要将 queue1 中的 n 个元素出队, 并入队 n + 1 个元素到 queue2​, 共有 2n + 1 次操作, 每次出队和入队操作的时间复杂度都是 O(1), 因此入栈操作的时间复杂度是 O(n)
 * 出栈操作对应将 queue1 ​的前端元素出队, 时间复杂度是 O(1)
 * 获得栈顶元素操作对应获得 queue1 的前端元素, 时间复杂度是 O(1)
 * 判断栈是否为空操作只需要判断 queue1 是否为空, 时间复杂度是 O(1)
 * <p>
 * 空间复杂度: O(n), 其中 n 是栈内的元素, 需要使用两个队列存储栈内的元素
 * <p>
 * Optimization of {@link Y2021M01D01_LC_Q225_S1}
 */
public class Y2021M01D01_LC_Q225_S2 {

    public static void main(String args[]) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(4);
        System.out.println(obj.empty());
        System.out.println(obj.top());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }

    static class MyStack {
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            // 此时 queue2.isEmpty() = true
            queue2.addLast(x);
            while (!queue1.isEmpty()) {
                queue2.addLast(queue1.pollFirst());
            }

            // 此时 queue1.isEmpty() = true
            Deque<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue1.isEmpty() ? -1 : queue1.pollFirst();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue1.isEmpty() ? -1 : queue1.peekFirst();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
