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
 * Solution: Depth First Search & Backtracking
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
 * Optimization of {@link Y2020M10D21_LC_Q47_S1}
 */
public class Y2020M10D22_LC_Q47_S2 {

    public static void main(String args[]) {
        Y2020M10D22_LC_Q47_S2 instance = new Y2020M10D22_LC_Q47_S2();
        // (new int[]{})
        // (new int[]{1, 1, 2})
        System.out.println(instance.permuteUnique(new int[]{1, 1, 2}));
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

        int preIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            // 如果 nums[i] 与 上一个被加入到当前位置的元素 相等, 为了避免重复, nums[i] 不能加入到当前位置
            if (!vis[i] && (preIndex < 0 || nums[i] != nums[preIndex])) {
                vis[i] = true;
                permutation.add(nums[i]);
                // 记录上一个被加入到当前位置的元素
                preIndex = i;

                backtrack(n, vis, nums, permutation, ans);

                vis[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
