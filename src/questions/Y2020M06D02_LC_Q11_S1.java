package questions;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1, a2, ..., an, 每个数代表坐标中的一个点 (i, ai)
 * 在坐标内画 n 条垂直线, 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 找出其中的两条线, 使得它们与 x 轴共同构成的容器可以容纳最多的水
 * <p>
 * 说明: 你不能倾斜容器
 * <p>
 * 提示:
 * n = height.length
 * 2 <= n <= 3 * 10^4
 * 0 <= height[i] <= 3 * 10^4
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.BruteForce}
 * <p>
 * 时间复杂度: O(N^2)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M06D02_LC_Q11_S1 {

    public static void main(String args[]) {
        Y2020M06D02_LC_Q11_S1 instance = new Y2020M06D02_LC_Q11_S1();

        // new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}

        System.out.println(instance.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int min = min(height[i], height[j]);
                int area = min * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
