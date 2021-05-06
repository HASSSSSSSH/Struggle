package questions;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 多数元素
 * 给定一个大小为 n 的数组, 找到其中的多数元素
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
 * 你可以假设数组是非空的, 并且给定的数组总是存在多数元素
 * <p>
 * 进阶:
 * 尝试设计时间复杂度为 O(n), 空间复杂度为 O(1) 的算法解决此问题
 * <p>
 * 示例:
 * 输入: [2, 2, 1, 1, 1, 2, 2]
 * 输出: 2
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.DivideAndConquer}, {@link questions.tags.BitManipulation}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: Boyer–Moore majority vote algorithm
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D07_LC_Q169_S1 {

    public static void main(String args[]) {
        Y2021M01D07_LC_Q169_S1 instance = new Y2021M01D07_LC_Q169_S1();

        // new int[]{2, 2, 1, 1, 1, 2, 2}

        System.out.println(instance.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public int majorityElement(int[] nums) {
        // 你可以假设数组是非空的, 并且给定的数组总是存在多数元素

        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res != nums[i]) {
                count--;
            } else {
                count++;
            }
            if (count <= 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
