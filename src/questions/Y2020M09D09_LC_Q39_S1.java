package questions;

import java.util.ArrayList;
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
 */
public class Y2020M09D09_LC_Q39_S1 {

    public static void main(String args[]) {
        Y2020M09D09_LC_Q39_S1 instance = new Y2020M09D09_LC_Q39_S1();
        // (new int[]{2, 3}, 6)
        // (new int[]{2, 3, 6, 7}, 7)
        System.out.println(instance.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), 0, candidates, target);
        return answer;
    }

    /**
     * 深度优先搜索, 未加入剪枝逻辑, 可以将其视为一种穷举法
     *
     * @param ans        最终结果
     * @param combine    当前选取的元素
     * @param curIndex   当前选取的元素的下标, 为了在搜索过程中排重
     * @param candidates 包含候选元素的数组
     * @param target     当前剩余的目标值, 数值 = 最开始的target - (combine[0] + ... + combine[combine.size() - 1])
     */
    public void dfs(List<List<Integer>> ans, List<Integer> combine, int curIndex, int[] candidates, int target) {
        if (target == 0) {
            // 当target = 0时, 说明当前的组合combine是其中一个解集
            // 注意到combine指向的List对象中的所有元素最终都会在回溯过程中被删除, 这里必须保存一个新的List对象
            // That is wrong!!
            // ans.add(combine);
            ans.add(new ArrayList<>(combine));
        }
        if (target > 0) {
            // 注意到 i = curIndex, 后面的元素在组合的时候不能再用到前面的元素, 避免产生重复的组合
            for (int i = curIndex; i < candidates.length; i++) {
                // 从curIndex开始, 遍历候选数组中的每个元素, 将其作为组合其中的一个元素
                combine.add(candidates[i]);
                dfs(ans, combine, i, candidates, target - candidates[i]);

                // 回溯, 删除之前添加的元素, 恢复方法最开始的状态(combine, curIndex, candidates, target都没有变化)
                combine.remove(combine.size() - 1);
            }
        }
    }
}
