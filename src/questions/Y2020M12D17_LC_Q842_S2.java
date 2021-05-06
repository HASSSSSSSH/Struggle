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
 * Reference: https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/javahui-su-suan-fa-tu-wen-xiang-jie-ji-b-vg5z/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Optimization of {@link Y2020M12D17_LC_Q842_S1}
 */
public class Y2020M12D17_LC_Q842_S2 {

    public static void main(String args[]) {
        Y2020M12D17_LC_Q842_S2 instance = new Y2020M12D17_LC_Q842_S2();

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
        dfs(0, S.toCharArray(), answer);
        return answer;
    }

    public boolean dfs(int begin, char[] chars, List<Integer> ans) {
        if (begin == chars.length && ans.size() >= 3) {
            return true;
        }

        for (int i = begin; i < chars.length; i++) {
            if (i > begin && '0' == chars[begin]) {
                break;
            }

            int num = string2Int(chars, begin, i);

            if (num < 0) {
                // overflow
                break;
            }

            int size = ans.size();
            if (size >= 2 && num > (ans.get(size - 1) + ans.get(size - 2))) {
                break;
            }

            if (size < 2 || num == (ans.get(size - 1) + ans.get(size - 2))) {
                ans.add(num);

                if (dfs(i + 1, chars, ans)) {
                    return true;
                }

                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    public int string2Int(char[] chars, int begin, int end) {
        int carry = 1;
        int num = 0;
        while (end >= begin) {
            // 在ASCII码表中, 字符'0'的十进制值为48
            // 那么, '0' - '0' = 0, '1' - '0' = 1
            num += (chars[end] - '0') * carry;

            if (num < 0) {
                // overflow
                return -1;
            }

            carry *= 10;
            end--;
        }
        return num;
    }
}
