package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 全排列 II
 * 给定一个可包含重复数字的序列, 返回所有不重复的全排列
 * <p>
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * Solution: Depth First Search & Backtrack
 * <p>
 * Reference:
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 * https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n * n!)
 * <p>
 * 空间复杂度: O(n)
 * 我们需要 O(n) 的标记数组, 同时在递归的时候栈深度会达到 O(n)
 * 因此总空间复杂度为 O(n + n) = O(2n) = O(n)
 * <p>
 * TAG:
 * 候选数组存在重复元素
 * 候选数组中的一个元素只能选取一次
 * 排列存在重复元素
 * 解集不包含重复排列
 * <p>
 * Different implementation of {@link Y2020M10D22_LC_Q47_S2}
 */
public class Y2020M10D22_LC_Q47_S3 {

    public static void main(String args[]) {
        Y2020M10D22_LC_Q47_S3 instance = new Y2020M10D22_LC_Q47_S3();
        // (new int[]{})
        // (new int[]{1, 1, 2})
        // (new int[]{1, 1, 1, 1})
        System.out.println(instance.permuteUnique(new int[]{1, 1, 1, 1}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 必须对数组进行排序
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums.length, new boolean[nums.length], nums, new ArrayList<>(), ans);
        return ans;
    }

    public void backtrack(int n, boolean[] vis, int[] nums, List<Integer> permutation, List<List<Integer>> ans) {
        if (permutation.size() == n) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]
                    // 由于nums数组是有序的
                    //
                    // 当 vis[i - 1] = true 时, nums[i - 1] 已经被选取, 本来就不应该出现在数组当中
                    // 无论 nums[i] == nums[i - 1] 是否成立, nums[i] 都是可以加入到排列当中
                    //
                    // 当 vis[i - 1] = false 时, nums[i - 1] 会有两种情况:
                    // 1. nums[i - 1] 已经被加入到排列, 经过回溯后, 有 vis[i - 1] = false
                    // 如果此时有 nums[i] == nums[i - 1], 为了避免重复, 那么 nums[i] 不需要再加入到排列
                    // 2. nums[i - 1] 没有被加入到排列, 原因是满足条件
                    // (num[i - 1] == nums[i - 2] && !vis[i - 2]) = true
                    // 如果此时有 nums[i] == nums[i - 1]
                    // 假设i = 2, 数组为[1, 1, 1], 那么元素 1 必定已经加入到排列中, nums[i] 不需要再加入到排列
                    // 假设i = 3, 数组为[0, 1, 1, 1], 那么元素 1 必定已经加入到排列中, nums[i] 不需要再加入到排列
                    || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            permutation.add(nums[i]);
            vis[i] = true;
            backtrack(n, vis, nums, permutation, ans);
            vis[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
