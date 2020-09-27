package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target , 找出 candidates 中所有可以使数字和为 target 的组合
 * candidates 中的数字可以无限制重复被选取
 * <p>
 * 说明:
 * 所有数字(包括 target)都是正整数
 * 解集不能包含重复的组合
 * <p>
 * 提示:
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的
 * 1 <= target <= 500
 * <p>
 * Solution: Depth First Search & Backtrace
 * <p>
 * Reference: https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 组合可以存在重复元素
 * 解集不包含重复组合
 * 所有数字(包括 target)都是正整数
 */
public class Y2020M09D09_LC_Q39_S2 {

    public static void main(String args[]) {
        Y2020M09D09_LC_Q39_S2 instance = new Y2020M09D09_LC_Q39_S2();
        // (new int[]{2, 3}, 6)
        // (new int[]{2, 3, 6, 7}, 7)
        System.out.println(instance.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 对候选数组排序, 以便接下来的剪枝操作
        Arrays.sort(candidates);

        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), 0, candidates, target);
        return answer;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> combine, int curIndex, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
        }
        for (int i = curIndex; i < candidates.length; i++) {
            // 剪枝
            // 由于数组是经过排序的, 当 target - candidates[i] < 0 时, 说明当 x > i 时, 总有 target - candidates[x] < 0
            // 从候选数组下标i开始的元素组成的组合, 总是不能满足 target - candidates[i] == 0, 直接中断循环
            if (target - candidates[i] < 0) {
                break;
            }

            combine.add(candidates[i]);
            dfs(ans, combine, i, candidates, target - candidates[i]);
            combine.remove(combine.size() - 1);
        }
    }
}
