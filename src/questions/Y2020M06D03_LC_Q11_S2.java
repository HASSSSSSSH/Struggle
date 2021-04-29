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
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Reference: https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(N), 双指针总计最多遍历整个数组一次
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M06D03_LC_Q11_S2 {

    public static void main(String args[]) {
        Y2020M06D03_LC_Q11_S2 instance = new Y2020M06D03_LC_Q11_S2();

        // new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}

        System.out.println(instance.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 用双指针分别指向数组的左右边界, 此时数组中所有的位置都有可能作为容器的边界, 因为我们还没有进行过任何尝试
     * 计算由当前左右边界与 x 轴共同构成的面积 area, 与当前面积的最大值 max 进行比较和更新
     * 之后, 我们将 对应的数字较小的那个指针 往 另一个指针 的方向移动一个位置, 表明 继续以这个指针作为容器的边界得到的面积不可能大于 area
     * 因此舍弃这个 对应的数字较小的那个指针
     * 最后重复以上过程, 直至两个指针重合, 此时的 max 就是最大面积
     * <p>
     * 证明:
     * 假设当前左指针和右指针指向的数分别为 x 和 y, 不失一般性, 我们假设 x ≤ y
     * 同时, 两个指针之间的距离为 t
     * 那么, 它们组成的容器的容量为: min(x, y) * t = x * t
     * <p>
     * 由于 x <= y, 右指针是 对应的数字较大的那个指针
     * 假如, 我们将右指针向左任意移动数个位置, 此时右指针指向的数设为 y1, 两个指针之间的距离为 t1
     * 显然有, t1 < t, min(x, y1) <= min(x, y)
     * 如果 y1 > y, 那么 min(x, y1) = min(x, y) = x
     * 如果 y1 <= y, 那么 min(x, y1) <= min(x, y)
     * 因此, area = min(x, y1) * t1 < min(x, y) * t <= max
     * <p>
     * 由此可知, 无论我们怎么移动 对应的数字较大的那个指针, 得到的容器的容量总是小于移动前容器的容量
     * 显然, 我们应当舍弃 对应的数字较小的那个指针 指向的位置, 将其向 另一个指针 的方向移动一个位置
     * 这样的操作才有可能使得由新边界构成的面积 area > 当前面积的最大值 max
     * <p>
     * 这样一来, 我们就将问题的规模减小了 1, 被我们丢弃的那个位置就相当于消失了
     * 此时的左右指针, 就指向了一个新的, 规模减少了的问题的数组的左右边界
     * 因此, 我们可以继续像之前 考虑第一步 那样考虑这个问题
     * 1. 求出当前双指针对应的容器的容量
     * 2. 对应数字较小的那个指针以后不可能作为容器的边界了, 将其丢弃, 并移动对应的指针
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (right > left) {
            int area = min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }

            // 移动短板
            // 如果移动的是长板, 那么由新边界得出的面积总是小于当前面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
