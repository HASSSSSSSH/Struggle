package problems.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 * 用队列实现栈
 * <p>
 * 请你仅使用队列实现一个后入先出 (LIFO) 的栈, 并支持普通队列的全部四种操作 (push, top, pop 和 empty)
 * 实现 MyStack 类:
 * void push(int x) 将元素 x 压入栈顶
 * int pop() 移除并返回栈顶元素
 * int top() 返回栈顶元素
 * boolean empty() 如果栈是空的, 返回 true, 否则, 返回 false
 * <p>
 * 注意:
 * 你只能使用队列的基本操作, 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的
 * 你所使用的语言也许不支持队列, 你可以使用 list (列表) 或者 deque (双端队列) 来模拟一个队列, 只要是标准的队列操作即可
 * <p>
 * 进阶: 你能否仅用一个队列来实现栈
 * <p>
 * Tags: {@link questions.tags.Queue}, {@link questions.tags.Stack}, {@link questions.tags.Design}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Queue}
 * <p>
 * 时间复杂度: 入栈操作 O(n), 其余操作都是 O(1), 其中 n 是栈内的元素个数
 * 入栈操作需要将队列中的 n 个元素出队, 并入队 n + 1 个元素到队列, 共有 2n + 1 次操作, 每次出队和入队操作的时间复杂度都是 O(1), 因此入栈操作的时间复杂度是 O(n)
 * 出栈操作对应将队列的前端元素出队, 时间复杂度是 O(1)
 * 获得栈顶元素操作对应获得队列的前端元素, 时间复杂度是 O(1)
 * 判断栈是否为空操作只需要判断队列是否为空, 时间复杂度是 O(1)
 * <p>
 * 空间复杂度: O(n), 其中 n 是栈内的元素
 * 需要使用一个队列存储栈内的元素
 */
public class Num225_Solution2 {

    public static void main(String[] args) {
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

    /**
     * 用一个队列实现栈
     */
    static class MyStack {
        Deque<Integer> queue = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            // 首先记下当前容器中元素的数量
            int n = queue.size();

            // 将新增元素放入容器的尾部
            queue.push(x);

            // 将容器的前 n 个元素按先进先出的顺序放到容器的尾部
            for (int i = 0; i < n; i++) {
                queue.push(queue.pop());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.isEmpty() ? -1 : queue.pop();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.isEmpty() ? -1 : queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
