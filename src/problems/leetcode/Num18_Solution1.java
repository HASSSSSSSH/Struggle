package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/4sum/submissions/
 * 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组 nums, 和一个目标值 target
 * <p>
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] (若两个四元组元素一一对应, 则认为两个四元组重复):
 * 0 <= a, b, c, d < n
 * a, b, c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * 你可以按 任意顺序 返回答案
 * <p>
 * 示例 1:
 * 输入: nums = [1, 0, -1, 0, -2, 2], target = 0
 * 输出: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
 * <p>
 * 示例 2:
 * 输入: nums = [2, 2, 2, 2, 2], target = 8
 * 输出: [[2, 2, 2, 2]]
 * <p>
 * 提示:
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}, {@link questions.tags.Sorting}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * 时间复杂度: O(n^3), 其中 n 是数组的长度
 * 排序的时间复杂度是 O(log n), 枚举四元组的时间复杂度是 O(n^3)
 * 因此总时间复杂度为 O(n^3 + n * log n) = O(n^3)
 * <p>
 * 空间复杂度: O(log n), 其中 n 是数组的长度
 * 空间复杂度主要取决于排序额外使用的空间
 * 此外排序修改了输入数组 nums, 实际情况中不一定允许
 * 因此也可以看成使用了一个额外的数组存储了数组 nums 的副本并排序, 空间复杂度为 O(n)
 */
public class Num18_Solution1 {

    public static void main(String[] args) {
        Num18_Solution1 instance = new Num18_Solution1();

        // new int[]{1, 0, -1, 0, -2, 2}, 0
        // new int[]{2, 2, 2, 2, 2}, 8
        // new int[]{-1, 0, 1, 2, -1, -4}, 1
        // new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, -1
        // new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2}, 2
        // new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000

        System.out.println(instance.fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return ans;
        }

        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 剪枝操作
            // 在确定第一个数之后, 如果满足条件 nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target
            // 说明剩下的三个数无论取什么值, 四数之和一定大于 target, 直接退出第一重循环
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            // 剪枝操作
            // 在确定第一个数之后, 如果满足条件 nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target
            // 说明剩下的三个数无论取什么值, 四数之和一定小于 target, 因此循环直接进入下一轮, 枚举 nums[i + 1]
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }

            int num1 = nums[i];
            for (int j = i + 1; j < n - 2; j++) {
                // 去重
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 剪枝操作
                // 在确定前两个数之后, 如果满足条件 num1 + nums[j] + nums[j + 1] + nums[j + 2] > target
                // 说明剩下的三个数无论取什么值, 四数之和一定大于 target, 因此退出第二重循环
                if ((long) num1 + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                // 剪枝操作
                // 在确定前两个数之后, 如果满足条件 num1 + nums[j] + nums[n - 2] + nums[n - 1] < target
                // 说明剩下的三个数无论取什么值, 四数之和一定小于 target, 因此第二重循环直接进入下一轮, 枚举 nums[j + 1]
                if ((long) num1 + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }

                int num2 = nums[j];
                int dif = target - num1 - num2;
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum < dif) {
                        do {
                            left++;
                        } while (left < right && nums[left - 1] == nums[left]);
                    } else if (sum > dif) {
                        do {
                            right--;
                        } while (left < right && nums[right + 1] == nums[right]);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(num1);
                        list.add(num2);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);

                        do {
                            left++;
                        } while (left < right && nums[left - 1] == nums[left]);
                        do {
                            right--;
                        } while (left < right && nums[right + 1] == nums[right]);
                    }
                }
            }
        }

        return ans;
    }
}
