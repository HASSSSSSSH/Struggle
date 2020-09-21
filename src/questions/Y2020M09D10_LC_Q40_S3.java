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
 * Reference: https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M09D10_LC_Q40_S3 {

    public static void main(String args[]) {
        Y2020M09D10_LC_Q40_S3 instance = new Y2020M09D10_LC_Q40_S3();
        // (new int[]{2, 2, 2, 6}, 10)
        // (new int[]{2, 3, 5, 2, 2, 6}, 10)
        System.out.println(instance.combinationSum2(new int[]{2, 2, 2, 6}, 10));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayDeque<>(), 0, candidates, target);
        return new ArrayList<>(answer);
    }

    public void dfs(List<List<Integer>> ans, Deque<Integer> combine, int begin, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                // 排除重复组合
                // 不再将 同一层的(同一次遍历的) 已经使用过的 相同数值的 元素加入组合
                continue;
            }
            combine.addLast(candidates[i]);
            dfs(ans, combine, i + 1, candidates, target - candidates[i]);
            combine.removeLast();
        }
    }
}
