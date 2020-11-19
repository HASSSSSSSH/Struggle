package questions;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n
 * 请你找出并返回 strs 的最大子集的大小, 该子集中 最多 有 m 个 0 和 n 个 1
 * 如果 x 的所有元素也是 y 的元素, 集合 x 是集合 y 的 子集
 * <p>
 * 示例 1:
 * 输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出: 4
 * 解释:
 * 最多有 5 个 0 和 3 个 1 的最大子集是 {"10", "0001", "1", "0"} , 因此答案是 4
 * 其他满足题意但较小的子集包括 {"0001", "1"} 和 {"10", "1", "0"}
 * {"111001"} 不满足题意, 因为它含 4 个 1 , 大于 n 的值 3
 * <p>
 * 示例 2:
 * 输入: strs = ["10", "0", "1"], m = 1, n = 1
 * 输出: 2
 * 解释: 最大的子集是 {"0", "1"} , 所以答案是 2
 * <p>
 * 提示:
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * Solution: Depth First Search & Backtrack
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Result: Time Limit Exceeded
 */
public class Y2020M11D06_LC_Q474_S1 {

    public static void main(String args[]) {
        Y2020M11D06_LC_Q474_S1 instance = new Y2020M11D06_LC_Q474_S1();

        // new String[]{"10", "0001", "111001", "1", "0"}, 5, 3
        // new String[]{"10", "0", "1"}, 1, 1
        // new String[]{"001", "110","0000","0000"}, 9, 2

        System.out.println(instance.findMaxForm(new String[]{"001", "110", "0000", "0000"}, 9, 2));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        return backtrack(strs, new boolean[strs.length], m, n);
    }

    public int backtrack(String[] strs, boolean[] vis, int m, int n) {
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            if (vis[i]) {
                continue;
            }
            int m2 = m;
            int n2 = n;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    m2--;
                } else {
                    n2--;
                }
            }
            if (m2 >= 0 && n2 >= 0) {
                vis[i] = true;
                int res = backtrack(strs, vis, m2, n2);
                if (res >= max) {
                    max = res + 1;
                }

                // 回溯到未选择 strs[i] 时候的状态
                vis[i] = false;
            }
        }
        return max;
    }
}
