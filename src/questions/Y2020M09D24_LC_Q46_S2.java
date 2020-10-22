package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 * 给定一个 没有重复 数字的序列, 返回其所有可能的全排列
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * Solution: Backtracking
 * Reference: https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 * <p>
 * 时间复杂度: O(n * n!), 其中 n 为序列的长度
 * 分析: https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 * <p>
 * 空间复杂度: O(n), 其中 n 为序列的长度
 * 除答案数组以外, 递归函数在递归过程中需要为每一层递归函数分配栈空间
 * 所以这里需要额外的空间且该空间取决于递归的深度, 这里可知递归调用深度为 O(n)
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组中的一个元素只能选取一次
 * 排列不存在重复元素
 * 解集不包含重复排列
 */
public class Y2020M09D24_LC_Q46_S2 {

    public static void main(String args[]) {
        Y2020M09D24_LC_Q46_S2 instance = new Y2020M09D24_LC_Q46_S2();
        // (new int[]{})
        // (new int[]{1, 2, 3})
        System.out.println(instance.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(nums.length);
        for (int num : nums) {
            arr.add(num);
        }
        backtrack(answer, arr, 0, nums.length);
        return answer;
    }

    /**
     * @param nums  候选数组, 其中 [0, first - 1] 范围内的元素为已选择的元素, [first, n] 范围内元素为待选择的元素
     * @param first 标记, 将候选数组分为 已选择 和 待选择 两部分
     * @param n     候选数组的总长度
     */
    public void backtrack(List<List<Integer>> ans, List<Integer> nums, int first, int n) {
        if (first == n) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        for (int i = first; i < nums.size(); i++) {
            // 交换 下标first 和 下标i 的元素, 使其满足 [0, first - 1] 范围内的元素为已选择的元素, [first, n] 范围内元素为待选择的元素
            nums.set(first, nums.set(i, nums.get(first)));
            // same as Collections.swap(nums, i, first);

            backtrack(ans, nums, first + 1, n);

            // 回溯, 恢复 选择了下标为i的元素 之前的状态
            nums.set(first, nums.set(i, nums.get(first)));
            // same as Collections.swap(nums, i, first);
        }
    }

    // more efficient
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> answer = new ArrayList<>();
    //     if (nums.length > 0) {
    //         List<Integer> arr = new ArrayList<>(nums.length);
    //         for (int num : nums) {
    //             arr.add(num);
    //         }
    //         backtrack(answer, 0, arr);
    //     } else {
    //         answer.add(new ArrayList<>());
    //     }
    //     return answer;
    // }
    //
    // public void backtrack(List<List<Integer>> ans, int begin, List<Integer> nums) {
    //     if (begin == nums.size() - 1) {
    //         ans.add(new ArrayList<>(nums));
    //         return;
    //     }
    //     for (int i = begin; i < nums.size(); i++) {
    //         Collections.swap(nums, begin, i);
    //         backtrack(ans, begin + 1, nums);
    //         Collections.swap(nums, begin, i);
    //     }
    // }
}
