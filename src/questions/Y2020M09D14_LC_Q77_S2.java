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
 * Reference: https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Optimization of Y2020M09D11_LC_Q77_S1
 */
public class Y2020M09D14_LC_Q77_S2 {

    public static void main(String args[]) {
        Y2020M09D14_LC_Q77_S2 instance = new Y2020M09D14_LC_Q77_S2();
        // (5, 2)
        System.out.println(instance.combine(4, 3));
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
            if (k > (n - i + 1)) {
                // 从i开始, 候选数组中剩余的数字已不能满足组成k个数的组合, 直接终止遍历
                break;
            }
            combine.add(i);
            dfs(ans, combine, i + 1, n, k - 1);
            combine.remove(combine.size() - 1);
        }
    }
}
