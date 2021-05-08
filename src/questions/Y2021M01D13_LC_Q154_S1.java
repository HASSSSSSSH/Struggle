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
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D13_LC_Q154_S1 {

    public static void main(String args[]) {
        Y2021M01D13_LC_Q154_S1 instance = new Y2021M01D13_LC_Q154_S1();

        // new int[]{1, 3, 5}
        // new int[]{2, 2, 2, 0, 1}

        System.out.println(instance.findMin(new int[]{2, 2, 2, 0, 1}));
    }

    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
