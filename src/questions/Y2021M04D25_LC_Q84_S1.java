package questions;

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
 * Solution: {@link questions.tags.BruteForce}
 * <p>
 * Reference: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
 * <p>
 * 时间复杂度: O(N^2), N 是输入数组的长度
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Result: Time Limit Exceeded
 */
public class Y2021M04D25_LC_Q84_S1 {

    public static void main(String args[]) {
        Y2021M04D25_LC_Q84_S1 instance = new Y2021M04D25_LC_Q84_S1();

        // new int[]{2, 1, 5, 6, 2, 3}
        // new int[]{6, 1}
        // new int[]{2, 1, 2}
        // new int[]{5, 4, 1, 2}

        System.out.println(instance.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int left = i - 1;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }

            int right = i + 1;
            while (right < n && heights[right] >= heights[i]) {
                right++;
            }

            int area = heights[i] * (right - left - 1);
            ans = area > ans ? area : ans;
        }

        return ans;
    }
}
