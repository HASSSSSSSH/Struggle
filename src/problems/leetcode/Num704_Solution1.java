package problems.leetcode;

/**
 * https://leetcode.cn/problems/binary-search/
 * 二分查找
 * <p>
 * 给定一个 n 个元素有序的 (升序) 整型数组 nums 和一个目标值 target, 写一个函数搜索 nums 中的 target
 * 如果目标值存在返回下标, 否则返回 -1
 * <p>
 * 示例 1:
 * 输入: nums = [-1, 0, 3, 5, 9, 12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * 输入: nums = [-1, 0, 3, 5, 9, 12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * 提示:
 * 你可以假设 nums 中的所有元素是不重复的
 * n 将在 [1, 10000] 之间
 * nums 的每个元素都将在 [-9999, 9999] 之间
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.BinarySearch}
 * <p>
 * Solution: {@link questions.tags.BinarySearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: O(logN), 其中 N 为数组的长度
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Reference: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0704.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md
 */
public class Num704_Solution1 {

    public static void main(String[] args) {
        Num704_Solution1 instance = new Num704_Solution1();

        // new int[]{-1, 0, 3, 5, 9, 12}, 9
        // new int[]{-1, 0, 3, 5, 9, 12}, 2
        // new int[]{1}, 1

        System.out.println(instance.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    /**
     * 注意到, 题目中提到了数组是升序的有序数组, 而且数组中无重复元素, 因此可以使用二分查找法
     * 以下的写法实现了在区间 [left, right] 中查找元素 target
     */
    public int search(int[] nums, int target) {
        // 避免当 target 小于 nums[0] 时 或者 target 大于 nums[nums.length - 1] 时, 进行多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        // 实现在区间 [left, right] 中查找元素 target
        int left = 0;

        // 实现在区间 [left, right] 中查找元素 target
        int right = nums.length - 1;

        // 注意, 当 left == right 满足时, 查找也是有意义的
        while (left <= right) {

            // int mid = left + ((right - left) >> 1);
            // int mid = right - ((right - left) >> 1);
            // 防止数值溢出有更好的写法
            int mid = (left + right) >>> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 注意, 如果令 right = mid, 可能导致死循环
                right = mid - 1;
            } else {
                // 注意, 如果令 left = mid, 可能导致死循环
                left = mid + 1;
            }
        }

        return -1;
    }
}
