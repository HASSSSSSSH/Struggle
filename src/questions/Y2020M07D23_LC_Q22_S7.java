package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Solution: Dynamic programming
 * Reference: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 时间复杂度: (待补充)
 * 空间复杂度: (待补充)
 */
public class Y2020M07D23_LC_Q22_S7 {

    public static void main(String args[]) {
        Y2020M07D23_LC_Q22_S7 instance = new Y2020M07D23_LC_Q22_S7();
        System.out.println(instance.generateParenthesis(5));
    }

    /**
     * dp[n], 即dp.get(n), 表示n对括号所有的能够生成的有效的括号组合
     * i 对括号的一个组合, 一定以左括号 "(" 开始, 不一定以 ")" 结尾
     * 为此, 我们可以枚举新的右括号 ")" 可能所处的位置, 得到所有的组合
     * 枚举的方式就是枚举左括号 "(" 和右括号 ")" 中间可能的合法的括号对数
     * 而剩下的合法的括号对数在与第一个左括号 "(" 配对的右括号 ")" 的后面, 这就用到了之前的状态
     * <p>
     * 状态方程:
     * dp[n] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     * 设可能的括号对数为i, 则 i∈[0, n - 1]
     * 剩下的括号对数 = n - 1 - i
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>(n + 1);

        // 动态规划: 计算dp[0]
        List<String> first = new ArrayList<>(1);
        first.add("");
        dp.add(first);
        for (int i = 1; i < n + 1; i++) {
            dp.add(new ArrayList<>());
        }
        // 动态规划: 从1开始, 计算dp[n]
        // i, 当前的括号对数
        for (int i = 1; i < n + 1; i++) {
            // j, 可能的括号对数
            // i - 1 - j, 剩余的括号对数
            for (int j = 0; j < i; j++) {
                List<String> left = dp.get(j);
                List<String> right = dp.get(i - 1 - j);
                for (int k = 0; k < left.size(); k++) {
                    // 遍历dp[j]
                    for (int l = 0; l < right.size(); l++) {
                        // 遍历dp[j]
                        String s = '(' + left.get(k) + ')' + right.get(l);
                        dp.get(i).add(s);
                    }
                }
            }
        }
        return dp.get(n);
    }
}
