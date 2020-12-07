package questions;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 数组中重复的数字
 * 找出数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
 * 数组中某些数字是重复的, 但不知道有几个数字重复了, 也不知道每个数字重复了几次
 * 请找出数组中任意一个重复的数字
 * <p>
 * 示例 1:
 * 输入: [2, 3, 1, 0, 2, 5, 3]
 * 输出: 2 或 3
 * <p>
 * Solution: HashMap
 * <p>
 * 时间复杂度: O(n), 使用HashSet, 添加元素的时间复杂度为 O(1), 故总的时间复杂度是 O(n)
 * <p>
 * 空间复杂度: O(n), 不重复的每个元素都可能存入集合, 因此占用 O(n) 额外空间
 */
public class Y2020M12D04_LCOF_Q3_S2 {

    public static void main(String args[]) {
        Y2020M12D04_LCOF_Q3_S2 instance = new Y2020M12D04_LCOF_Q3_S2();

        // new int[]{2, 3, 1, 0, 2, 5, 3}

        System.out.println(instance.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (!map.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
