package questions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图, 计算按此排列的柱子, 下雨之后能接多少雨水
 * <p>
 * 提示:
 * n == height.length
 * 0 <= n <= 3 * 10^4
 * 0 <= height[i] <= 10^5
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.Stack}, {@link questions.tags.TwoPointers}, {@link questions.tags.DynamicProgramming}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * Solution: {@link questions.tags.Stack}
 * <p>
 * Reference: https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
 * <p>
 * 时间复杂度: O(n), 其中 n 是数组 height 的长度, 从 0 到 n - 1 的每个下标最多只会入栈和出栈各一次
 * <p>
 * 空间复杂度: O(n), 其中 n 是数组 height 的长度, 空间复杂度主要取决于栈空间, 栈的大小不会超过 n
 */
public class Y2021M04D08_LC_Q42_S1 {

    public static void main(String args[]) {
        Y2021M04D08_LC_Q42_S1 instance = new Y2021M04D08_LC_Q42_S1();

        // new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
        // new int[]{4, 2, 0, 3, 2, 5}
        // new int[]{1, 0, 0, 2}
        // new int[]{2, 1, 0, 0, 2}

        System.out.println(instance.trap(new int[]{2, 1, 0, 0, 2}));
    }

    /**
     * 维护一个单调栈, 单调栈存储的是下标, 满足从栈底到栈顶的下标对应的数组 height 中的元素递减
     * 假设栈中元素 i > j, 则有 height[i] <= height[j]
     * <p>
     * 现在从左到右遍历数组, 当遍历到下标 i 时, 如果栈内至少有两个元素, 记栈顶元素为 top, 而 top 的后面一个元素是 left
     * 此时一定有 height[left] >= height[top]
     * <p>
     * 比较 height[i] 和 height[top]:
     * <p>
     * 如果 height[i] > height[top], 且 height[left] > height[top], 则得到一个可以接雨水的区域
     * 那么该区域的宽度是 i - left - 1, 高度是 min(height[left], height[i]) - height[top]
     * 根据宽度和高度即可计算得到该区域能接的雨水量
     * 注意到由于栈顶元素的出栈, 此时栈顶元素下标为 left, 假设此时栈顶元素的下一个元素的下标为 left'
     * 如果有 height[i] > height[left], height[i] 和 height[left'] 之间仍有可能组成一个可以接雨水的区域 (此时 height[left'] > height[left])
     * 因此对 height[i] 和 height[left] 重复比较过程
     * <p>
     * 如果 height[i] > height[top], 且 height[left] == height[top], 那么有 height[i] > height[top] = height[left]
     * 则高度 min(height[left], height[i]) - height[top] = 0
     * 此区域能接的雨水量为 0
     * 注意到由于栈顶元素的出栈, 此时栈顶元素下标为 left, 假设此时栈顶元素的下一个元素的下标为 left'
     * 如果有 height[i] > height[left], height[i] 和 height[left'] 之间仍有可能组成一个可以接雨水的区域 (此时 height[left'] > height[left])
     * 因此对 height[i] 和 height[left] 重复比较过程
     * <p>
     * 如果 height[i] <= height[top], 则元素 i 不可能与栈中元素组成一个可以接雨水的区域
     * 将元素 i 放入栈顶, 继续遍历数组
     */
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 注意到, 当 i == 0 时, stack.peekLast() 将会返回 null
            // 因此需要增加条件判断: !stack.isEmpty()
            while (!stack.isEmpty()
                    // 循环对 height[i] 和 height[top] 进行比较
                    && height[i] > height[stack.peekLast()]) {

                // 取出栈顶元素
                int preIndex = stack.pollLast();

                if (stack.isEmpty()) {
                    // 栈当前已经没有元素可以作为左边界, 只有两个元素无法构成一个容器, 因此跳出循环
                    break;
                }

                // 左边界元素的下标
                int leftBorderIndex = stack.peekLast();

                // 取左右边界的较小值
                int minBorder = Math.min(height[leftBorderIndex], height[i]);

                // 计算面积
                // width = i - leftBorderIndex - 1
                // height = minBorder - height[preIndex]
                int area = (minBorder - height[preIndex]) * (i - leftBorderIndex - 1);
                ans += area;

            }

            // 注意到, 栈中存储的是元素的下标
            // 因为在面积的计算过程中, 除了需要高度以外, 还需要通过元素的下标来获取宽度
            stack.addLast(i);
        }

        return ans;
    }
}
