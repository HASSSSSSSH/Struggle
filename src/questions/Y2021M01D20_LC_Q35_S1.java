package questions;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值, 在数组中找到目标值, 并返回其索引
 * 如果目标值不存在于数组中, 返回它将会被按顺序插入的位置
 * <p>
 * 说明:
 * 你可以假设数组中无重复元素
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.BinarySearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * Solution: {@link questions.tags.BinarySearch}
 * <p>
 * 时间复杂度: O(logN), 其中 n 为数组的长度, 二分查找所需的时间复杂度为 O(logN)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D20_LC_Q35_S1 {

    public static void main(String args[]) {
        Y2021M01D20_LC_Q35_S1 instance = new Y2021M01D20_LC_Q35_S1();

        // new int[]{1, 3, 5, 8}, 5
        // new int[]{1, 3, 5, 8}, 2
        // new int[]{1, 3, 5, 8}, 9
        // new int[]{1, 3, 5, 8}, 0
        // new int[]{1, 3, 5, 8, 10}, 6

        System.out.println(instance.searchInsert(new int[]{1, 3, 5, 8, 10}, 6));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        // left > right 总是成立
        // 此时 left 正好指向目标值被按顺序插入的位置
        return left;
    }
}
