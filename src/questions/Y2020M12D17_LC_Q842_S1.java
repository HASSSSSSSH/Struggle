package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * 将数组拆分成斐波那契序列
 * <p>
 * 给定一个数字字符串 S, 比如 S = "123456579", 我们可以将它分成斐波那契式的序列 [123, 456, 579]
 * <p>
 * 形式上, 斐波那契式序列是一个非负整数列表 F, 且满足:
 * 0 <= F[i] <= 2^31 - 1, 也就是说, 每个整数都符合 32 位有符号整数类型
 * F.length >= 3
 * 对于所有的0 <= i < F.length - 2, 都有 F[i] + F[i + 1] = F[i + 2] 成立
 * <p>
 * 注意:
 * 将字符串拆分成小块时, 每个块的数字一定不要以零开头, 除非这个块是数字 0 本身
 * <p>
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块, 如果不能拆分则返回 []
 * <p>
 * 示例 1:
 * 输入: "123456579"
 * 输出: [123, 456, 579]
 * <p>
 * 示例 2:
 * 输入: "11235813"
 * 输出: [1, 1, 2, 3, 5, 8, 13]
 * <p>
 * 示例 3:
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成
 * <p>
 * 示例 4:
 * 输入: "0123"
 * 输出: []
 * 解释: 每个块的数字不能以零开头, 因此 "01", "2", "3" 不是有效答案
 * <p>
 * 示例 5:
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11, 0, 11, 11] 也同样被接受
 * <p>
 * 提示:
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.Backtracking}, {@link questions.tags.Greedy}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * Solution: {@link questions.tags.DepthFirstSearch}, {@link questions.tags.Backtracking}
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M12D17_LC_Q842_S1 {

    public static void main(String args[]) {
        Y2020M12D17_LC_Q842_S1 instance = new Y2020M12D17_LC_Q842_S1();

        // "123456579"
        // "11235813"
        // "112358130"
        // "0123"
        // "1101111"
        // "1012"
        // "5511816597"

        System.out.println(instance.splitIntoFibonacci("11235813"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> answer = new ArrayList<>();
        dfs(0, S.length(), S, answer);
        return answer;
    }

    public boolean dfs(int begin, int n, String s, List<Integer> ans) {
        if (ans.size() >= 3) {
            if (ans.get(ans.size() - 1) != (ans.get(ans.size() - 2) + ans.get(ans.size() - 3))) {
                return false;
            } else if (begin == n) {
                return true;
            }
        }

        if (begin < n && '0' == s.charAt(begin)) {
            ans.add(0);
            if (dfs(begin + 1, n, s, ans)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            return false;
        }

        for (int i = begin; i < n; i++) {
            try {
                int num = Integer.valueOf(s.substring(begin, i + 1));
                ans.add(num);
                if (dfs(i + 1, n, s, ans)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            } catch (Exception e) {
                // ignore
            }
        }
        return false;
    }
}
