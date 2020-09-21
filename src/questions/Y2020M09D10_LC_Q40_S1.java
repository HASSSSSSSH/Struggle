package questions;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 组合总和 II
 * 给定一个的数组 candidates 和一个目标数 target , 找出 candidates 中所有可以使数字和为 target 的组合
 * candidates 中的每个数字在每个组合中只能使用一次
 * <p>
 * 说明:
 * 所有数字(包括 target)都是正整数
 * 解集不能包含重复的组合
 * <p>
 * 提示:
 * 没有说明数组当中无重复元素
 * <p>
 * Solution: Depth First Search & Backtrace
 * Result: Timeout
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M09D10_LC_Q40_S1 {

    public static void main(String args[]) {
        Y2020M09D10_LC_Q40_S1 instance = new Y2020M09D10_LC_Q40_S1();
        // (new int[]{2, 2, 2, 6}, 10)
        // (new int[]{2, 3, 5, 2, 2, 6}, 10)
        System.out.println(instance.combinationSum2(new int[]{2, 3, 5, 2, 2, 6}, 10));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> answer = new HashSet<>();
        dfs(answer, new ArrayList<>(), 0, candidates, target);
        return new ArrayList<>(answer);
    }

    /**
     * timeout
     */
    public void dfs(Set<List<Integer>> ans, List<Integer> combine, int begin, int[] candidates, int target) {
        if (target == 0) {
            // 不再添加重复的组合

            Integer[] arr = new Integer[combine.size()];
            combine.toArray(arr);

            // Set排重, 需要List中元素顺序一致
            // [1, 2] 和 [2, 1] 是不同的List
            // 因此需要对List排序
            Arrays.sort(arr);

            ans.add(new ArrayList<>(Arrays.asList(arr)));
            return;
        }

        // 从begin开始遍历数组
        for (int i = begin; i < candidates.length; i++) {
            combine.add(candidates[i]);

            // 数组中每个元素在一个组合中只能使用一次, 所以下一元素的下标index = 当前所选择元素的index + 1
            dfs(ans, combine, i + 1, candidates, target - candidates[i]);

            combine.remove(combine.size() - 1);
        }
    }
}
