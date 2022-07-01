package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums, 判断 nums 中是否存在三个元素 a, b, c, 使得 a + b + c = 0
 * 请你找出所有和为 0 且不重复的三元组
 * 注意: 答案中不可以包含重复的三元组
 * <p>
 * 示例 1:
 * 输入: nums = [-1, 0, 1, 2, -1, -4]
 * 输出: [[-1, -1, 2], [-1, 0, 1]]
 * <p>
 * 示例 2:
 * 输入: nums = []
 * 输出: []
 * <p>
 * 示例 3:
 * 输入: nums = [0]
 * 输出: []
 * <p>
 * 提示:
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}, {@link questions.tags.Sorting}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(N^2), 其中 N 是数组 nums 的长度
 * <p>
 * 空间复杂度: O(logN), 其中 N 是数组 nums 的长度, 我们忽略存储答案的空间, 额外的排序的空间复杂度为 O(logN)
 * 然而我们修改了输入的数组 nums, 在实际情况下不一定允许
 * 因此也可以看成使用了一个额外的数组存储了 nums 的副本并进行排序, 空间复杂度为 O(N)
 * <p>
 * Reference:
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0015.%E4%B8%89%E6%95%B0%E4%B9%8B%E5%92%8C.md
 * https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
 */
public class Num15_Solution1 {

    public static void main(String[] args) {
        Num15_Solution1 instance = new Num15_Solution1();

        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2};

        System.out.println(instance.threeSum(arr));
    }

    /**
     * 需要注意, 数组 nums 可能包含重复元素, 但答案中不可以包含重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 如果 nums[i] > 0, 那么在 nums 的剩余元素中, 不可能满足 a + b + c = 0
            if (nums[i] > 0) {
                break;
            }

            // 过滤数组中的重复元素, 避免答案中包含重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int dif = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < dif) {
                    // 当 sum < dif 时, 指针 left 向右移动
                    // while 语句的目的是过滤重复元素
                    do {
                        left++;
                    } while (left < right && nums[left - 1] == nums[left]);
                } else if (sum > dif) {
                    // 当 sum > dif 时, 指针 right 向左移动
                    // while 语句的目的是过滤重复元素
                    do {
                        right--;
                    } while (left < right && nums[right + 1] == nums[right]);
                } else {
                    // 此时 sum == dif
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
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

        return ans;
    }
}
