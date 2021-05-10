package questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数, 用来表示柱状图中各个柱子的高度, 每个柱子彼此相邻, 且宽度为 1
 * 求在该柱状图中, 能够勾勒出来的矩形的最大面积
 * <p>
 * 示例:
 * 输入: [2, 1, 5, 6, 2, 3]
 * 输出: 10
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.Stack}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * Solution: {@link questions.tags.Stack}
 * <p>
 * Reference: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 * <p>
 * 时间复杂度: O(N), 输入数组里的每一个元素入栈一次, 出栈一次
 * <p>
 * 空间复杂度: O(N), 栈的空间最多为 N
 */
public class Y2021M04D27_LC_Q84_S2 {

    public static void main(String args[]) {
        Y2021M04D27_LC_Q84_S2 instance = new Y2021M04D27_LC_Q84_S2();

        // new int[]{2, 1, 5, 6, 2, 3}
        // new int[]{6, 1}
        // new int[]{2, 1, 2}
        // new int[]{5, 4, 1, 2}

        System.out.println(instance.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int index = stack.pollLast();
                while (!stack.isEmpty() && heights[stack.peekLast()] == heights[index]) {
                    stack.pollLast();
                }

                int width;
                if (!stack.isEmpty()) {
                    width = i - stack.peekLast() - 1;
                } else {
                    width = i;
                }

                int area = width * heights[index];
                ans = area > ans ? area : ans;
            }
            stack.addLast(i);
        }

        // int right = n;
        while (stack.size() > 1) {
            int index = stack.pollLast();
            int left = stack.peekLast();

            // int width = right - left - 1;
            int width = n - left - 1;
            int area = heights[index] * width;

            ans = area > ans ? area : ans;
        }

        if (!stack.isEmpty()) {
            int area = heights[stack.pollLast()] * n;
            ans = area > ans ? area : ans;
        }

        return ans;
    }
}
