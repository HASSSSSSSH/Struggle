package problems.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/two-sum/
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在该数组中找出 和为目标值 target 的那 两个 整数, 并返回它们的数组下标
 * 你可以假设每种输入只会对应一个答案, 但是数组中同一个元素在答案里不能重复出现
 * 你可以按任意顺序返回答案
 * <p>
 * 示例 1:
 * 输入: nums = [2, 7, 11, 15], target = 9
 * 输出: [0, 1]
 * 解释: 因为 nums[0] + nums[1] == 9, 返回 [0, 1]
 * <p>
 * 示例 2:
 * 输入: nums = [3, 2, 4], target = 6
 * 输出: [1, 2]
 * <p>
 * 示例 3:
 * 输入: nums = [3, 3], target = 6
 * 输出: [0, 1]
 * <p>
 * 提示:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 只会存在一个有效答案
 * <p>
 * 进阶: 尝试设计一个时间复杂度小于 O(n^2) 的算法
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.HashTable}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#B}
 * <p>
 * 时间复杂度: O(N), 其中 N 是数组中的元素数量
 * 对于每一个元素 x, 我们可以 O(1) 地寻找 target - x
 * <p>
 * 空间复杂度: O(N), 其中 N 是数组中的元素数量, 主要为哈希表的开销
 */
public class Num1_Solution1 {

    public static void main(String[] args) {
        Num1_Solution1 instance = new Num1_Solution1();

        // int[] nums = new int[]{2, 7, 11, 15};
        // int target = 9;
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        // int[] nums = new int[]{3, 3};
        // int target = 6;

        int[] ans = instance.twoSum(nums, target);

        System.out.println(Arrays.toString(ans));
        System.out.println("num1: " + nums[ans[0]] + ", num2: " + nums[ans[1]]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (hashMap.containsKey(dif)) {
                ans[0] = hashMap.get(dif);
                ans[1] = i;
                break;
            }
            hashMap.put(nums[i], i);
        }

        return ans;
    }
}
