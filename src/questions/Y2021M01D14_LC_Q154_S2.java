package questions;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 寻找旋转排序数组中的最小值 II
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * 例如, 数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2], 请找出其中最小的元素
 * 注意数组中可能存在重复的元素
 * <p>
 * 示例 1:
 * 输入: [1, 3, 5]
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: [2, 2, 2, 0, 1]
 * 输出: 0
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.BinarySearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * Solution: {@link questions.tags.BinarySearch}
 * <p>
 * Reference: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-by-liweiwei1419/
 * <p>
 * 时间复杂度: 平均时间复杂度为 O(logN), 其中 N 是数组 nums 的长度
 * 如果数组是随机生成的, 那么数组中包含相同元素的概率很低, 在二分查找的过程中, 大部分情况都会忽略一半的区间
 * 而在最坏情况下, 如果数组中的元素完全相同, 那么 while 循环就需要执行 N 次, 每次忽略区间的右端点, 时间复杂度为 O(N)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D14_LC_Q154_S2 {

    public static void main(String args[]) {
        Y2021M01D14_LC_Q154_S2 instance = new Y2021M01D14_LC_Q154_S2();

        // new int[]{1, 3, 5}
        // new int[]{2, 2, 2, 0, 1}

        System.out.println(instance.findMin(new int[]{2, 2, 2, 0, 1}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // same as (low + ((high - low) >> 1))
            // >>>(无符号右移): 无论符号位是 0 或者 1, 将该数的二进制值整体(包括符号位)右移, 右边部分舍弃, 左边部分总是以 0 填充
            // 即使 (low + high) 溢出, 也能够得出正确答案
            int mid = (left + right) >>> 1;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        // left 在右移之后, 其值也总是满足: left <= right
        // right 在左移之后, 其值也总是满足: left <= right
        // 所以, 当条件 (left < right) 不再满足时, left == right
        // 此时 left 和 right 都指向数组中最小的元素
        return nums[left];
    }
}
