package questions;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合, 组合中只允许含有 1 - 9 的正整数, 并且每种组合中不存在重复的数字
 * <p>
 * 说明:
 * 所有数字(包括 target)都是正整数
 * 解集不能包含重复的组合
 * <p>
 * Solution: Depth First Search & Backtrace
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M09D11_LC_Q216_S1 {

    public static void main(String args[]) {
        Y2020M09D11_LC_Q216_S1 instance = new Y2020M09D11_LC_Q216_S1();
        // (2, 9)
        // (1, 10)
        System.out.println(instance.combinationSum3(2, 10));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), 1, k, n);
        return answer;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> combine, int begin, int times, int target) {
        if (times == 0 && target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        } else if (times <= 0) {
            return;
        }
        for (int i = begin; i < 10; i++) {
            if (target - i < 0) {
                break;
            }
            combine.add(i);
            dfs(ans, combine, i + 1, times - 1, target - i);
            combine.remove(combine.size() - 1);
        }
    }
}
