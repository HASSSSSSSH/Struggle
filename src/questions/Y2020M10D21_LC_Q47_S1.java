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
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * TAG:
 * 候选数组存在重复元素
 * 候选数组中的一个元素只能选取一次
 * 排列存在重复元素
 * 解集不包含重复排列
 */
public class Y2020M10D21_LC_Q47_S1 {

    public static void main(String args[]) {
        Y2020M10D21_LC_Q47_S1 instance = new Y2020M10D21_LC_Q47_S1();
        // (new int[]{})
        // (new int[]{1, 1, 2})
        System.out.println(instance.permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 必须对数组进行排序
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(nums.length);
        for (int num : nums) {
            arr.add(num);
        }
        backtrack(ans, new ArrayList<>(), arr, nums.length);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> permutation, List<Integer> nums, int n) {
        if (permutation.size() == n) {
            ans.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            // 剪枝
            // 数组是经过排序的, 在permutation数组中的同一个位置, 不重复选取 值是一样的元素
            // 可以避免生成重复排列
            if (i == 0 || num != nums.get(i - 1)) {

                // 从候选数组中删除 num
                // 此时, 候选数组仍然是经过排序的
                nums.remove(i);
                // 选择 num , 将其加入到排列
                permutation.add(num);

                backtrack(ans, permutation, nums, n);

                // 恢复 选择了num 之前的状态
                permutation.remove(permutation.size() - 1);
                nums.add(i, num);
            }
        }
    }
}
