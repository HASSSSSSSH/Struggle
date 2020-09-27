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
 * Reference:
 * https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 * https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
 * <p>
 * 时间复杂度: https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
 * <p>
 * 空间复杂度: https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode-solution/
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组中的一个元素只能选取一次
 * 组合不存在重复元素
 * 解集不包含重复组合
 * 所有数字都是正整数
 */
public class Y2020M09D14_LC_Q77_S3 {

    public static void main(String args[]) {
        Y2020M09D14_LC_Q77_S3 instance = new Y2020M09D14_LC_Q77_S3();
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
     * @param begin   从第begin个数字开始
     * @param k       还剩k个数完成一个组合
     */
    public void dfs(List<List<Integer>> ans, List<Integer> combine, int begin, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        if (k > (n - begin + 1)) {
            // 从begin开始, 候选数组中剩余的数字已不能满足组成k个数的组合, 直接返回
            return;
        }

        // 不考虑将第begin个数加入组合, 直接进入下一个递归
        dfs(ans, combine, begin + 1, n, k);

        // 考虑将第begin个数加入组合, 此时 组合中剩余数字的数量 - 1, 进入下一个递归
        combine.add(begin);
        dfs(ans, combine, begin + 1, n, k - 1);
        combine.remove(combine.size() - 1);
    }
}
