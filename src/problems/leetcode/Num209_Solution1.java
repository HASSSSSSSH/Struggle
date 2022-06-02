package problems.leetcode;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr], 并返回其长度
 * 如果不存在符合条件的子数组, 返回 0
 * <p>
 * 示例 1:
 * 输入: target = 7, nums = [2, 3, 1, 2, 4, 3]
 * 输出: 2
 * 解释: 子数组 [4, 3] 是该条件下的长度最小的子数组
 * <p>
 * 示例 2:
 * 输入: target = 4, nums = [1, 4, 4]
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: target = 11, nums = [1, 1, 1, 1, 1, 1, 1, 1]
 * 输出: 0
 * <p>
 * 提示:
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * <p>
 * 进阶:
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.SlidingWindow}, {@link questions.tags.BinarySearch}, {@link questions.tags.PrefixSum}
 * <p>
 * Solution: {@link questions.tags.SlidingWindow}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n), 其中 n 是数组的长度
 * 指针 fromIndex 和 toIndex 最多各移动 n 次
 * <p>
 * 空间复杂度: O(1)
 */
public class Num209_Solution1 {

    public static void main(String[] args) {
        Num209_Solution1 instance = new Num209_Solution1();

        // 7, new int[]{2, 3, 1, 2, 4, 3}
        // 7, new int[]{2, 3, 1, 2, 0, 7}
        // 4, new int[]{1, 4, 4}
        // 11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}

        System.out.println(instance.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 关于时间复杂度:
     * 不要以为 for 里放一个 while 就以为是 O(n^2), 主要是看每一个元素被操作的次数
     * 每个元素在滑动窗后进来操作一次, 出去操作一次, 每个元素最多被操作两次, 所以时间复杂度是 O(2 * n) = O(n)
     */
    public int minSubArrayLen(int target, int[] nums) {
        // 不能初始化为 0
        // 初始化为 (nums.length + 1) 使得可以与 (toIndex - fromIndex + 1) 方便地进行比较
        // 由于子数组的长度不可能大于 nums.length, 这样也能方便地判断出是否存在符合条件的子数组
        int ans = nums.length + 1;

        // 存储当前子数组的和
        int sum = 0;

        // 滑动窗口是一个连续的区间 [fromIndex, toIndex]
        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            // 为了覆盖所有可能符合条件的子数组, 必须更新 sum 和 toIndex, 扩大滑动窗口
            sum += nums[i];
            toIndex = i;

            if (sum >= target) {
                // 更新滑动窗口
                while ((sum - nums[fromIndex]) >= target) {
                    // 当 (sum - nums[fromIndex]) >= target 满足时, 说明滑动窗口的起始位置可以更新
                    // 滑动窗口左侧向前移动一位, 缩小滑动窗口
                    sum -= nums[fromIndex];
                    fromIndex++;
                }

                // 由于当前子数组满足 sum >= target, 尝试更新结果 ans
                int len = toIndex - fromIndex + 1;
                ans = ans > len ? len : ans;
            }
        }

        return ans > nums.length ? 0 : ans;
    }
}
