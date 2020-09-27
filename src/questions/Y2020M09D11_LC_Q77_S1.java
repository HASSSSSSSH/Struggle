package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 组合
 * 给定两个整数 n 和 k, 返回 1 ... n 中所有可能的 k 个数的组合
 * <p>
 * 提示:
 * 组合中不包含重复数字
 * <p>
 * Solution: Depth First Search & Backtrace
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组中的一个元素只能选取一次
 * 组合不存在重复元素
 * 解集不包含重复组合
 * 所有数字都是正整数
 */
public class Y2020M09D11_LC_Q77_S1 {

    public static void main(String args[]) {
        Y2020M09D11_LC_Q77_S1 instance = new Y2020M09D11_LC_Q77_S1();
        // (5, 2)
        System.out.println(instance.combine(5, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(answer, new ArrayList<>(), 1, n, k);
        return answer;
    }

    /**
     * @param combine 已选取数字的组合
     * @param begin   从第begin个数字开始遍历
     * @param k       还剩k个数完成一个组合
     */
    public void dfs(List<List<Integer>> ans, List<Integer> combine, int begin, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = begin; i <= n; i++) {
            combine.add(i);
            dfs(ans, combine, i + 1, n, k - 1);
            combine.remove(combine.size() - 1);
        }
    }
}
