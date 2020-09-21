package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Y2020M09D10_LC_Q40_S2 {

    public static void main(String args[]) {
        Y2020M09D10_LC_Q40_S2 instance = new Y2020M09D10_LC_Q40_S2();
        // (new int[]{2, 2, 2, 6}, 10)
        // (new int[]{2, 3, 5, 2, 2, 6}, 10)
        System.out.println(instance.combinationSum2(new int[]{2, 3, 5, 2, 2, 6}, 10));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), 0, candidates, target);
        return new ArrayList<>(answer);
    }

    public void dfs(List<List<Integer>> ans, List<Integer> combine, int begin, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        // 数组中元素都是正整数
        int pre = -1;

        // 从begin开始遍历数组
        for (int i = begin; i < candidates.length; i++) {
            // 排除重复组合
            // 不再将 同一层的(同一次遍历的) 已经使用过的 相同数值的 元素加入组合
            // 例如, 当前有 combine = [2] , begin = [1] , candidates = [2,2,2,6] , target = 4
            // 从数组下标1开始, 此时只需要选取 index=1 的元素 2 , 为了不得到重复组合, index=2 的元素 2 就不能再选取
            if (candidates[i] != pre) {
                if (target - candidates[i] < 0) {
                    break;
                }
                pre = candidates[i];
                combine.add(candidates[i]);

                // 数组中每个元素在一个组合中只能使用一次, 所以下一元素的下标index = 当前所选择元素的index + 1
                dfs(ans, combine, i + 1, candidates, target - candidates[i]);

                combine.remove(combine.size() - 1);
            }
        }
    }
}
