package questions;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素
 * 给定一个输入数组 nums, 其中 nums[i] ≠ nums[i+1], 找到峰值元素并返回其索引
 * 数组可能包含多个峰值, 在这种情况下, 返回任何一个峰值所在位置即可
 * 你可以假设 nums[-1] = nums[n] = -∞ (负无穷)
 * <p>
 * 说明: 你的解法应该是 O(logN) 时间复杂度的
 * <p>
 * 示例1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素, 你的函数应该返回其索引 2
 * <p>
 * 示例2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1, 其峰值元素为 2; 或者返回索引 5, 其峰值元素为 6
 * <p>
 * Solution: Binary Search
 * <p>
 * Reference: https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
 * <p>
 * 时间复杂度: O(log2 (n)), 其中 n 为 nums 数组的长度
 * 每一步都将搜索空间减半, 因此总的搜索空间只需要 O(log2 (n)) 步
 * <p>
 * 空间复杂度: O(log2 (n)), 其中 n 为 nums 数组的长度
 * 每一步都将搜索空间减半, 因此总的搜索空间只需要 O(log2 (n)) 步
 * 于是, 递归树的深度为 O(log2 (n))
 */
public class Y2020M10D15_LC_Q162_S4 {

    public static void main(String args[]) {
        Y2020M10D15_LC_Q162_S4 instance = new Y2020M10D15_LC_Q162_S4();

        // (new int[]{1, 2, 3, 1})
        // (new int[]{1, 2, 1, 3, 5, 6, 4})
        // (new int[]{2, 1})
        // (new int[]{1, 2})
        // (new int[]{1, 1, 1, 1, 6})
        System.out.println(instance.findPeakElement(new int[]{1, 1, 1, 1, 6}));
    }

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    public int findPeakElement(int[] nums, int left, int right) {
        if (left < right) {
            // same as ((left + right) / 2)
            int mid = left + (right - left) / 2;

            // left first
            // if (nums[mid] < nums[mid + 1]) {
            //     return findPeakElement(nums, mid + 1, right);
            // } else {
            //     return findPeakElement(nums, left, mid);
            // }

            // right first
            if (nums[mid] > nums[mid + 1]) {
                return findPeakElement(nums, left, mid);
            } else {
                return findPeakElement(nums, mid + 1, right);
            }
        }
        return left;
    }
}
