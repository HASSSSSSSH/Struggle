package questions;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 最长公共子序列
 * 给定两个字符串 text1 和 text2, 返回这两个字符串的最长公共子序列的长度
 * 一个字符串的 子序列 是指这样一个新的字符串:
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符 (也可以不删除任何字符) 后组成的新字符串
 * 例如, "ace" 是 "abcde" 的子序列, 但 "aec" 不是 "abcde" 的子序列
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列
 * 若这两个字符串没有公共子序列, 则返回 0
 * <p>
 * 示例 1:
 * 输入: text1 = "abcde", text2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace", 它的长度为 3
 * <p>
 * 示例 2:
 * 输入: text1 = "abc", text2 = "abc"
 * 输出: 3
 * 解释: 最长公共子序列是 "abc", 它的长度为 3
 * <p>
 * 示例 3:
 * 输入: text1 = "abc", text2 = "def"
 * 输出: 0
 * 解释: 两个字符串没有公共子序列, 返回 0
 * <p>
 * 提示:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符
 * <p>
 * Solution: Brute force & Recursion
 * <p>
 * Reference: https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M11D25_LC_Q1143_S1 {

    public static void main(String args[]) {
        Y2020M11D25_LC_Q1143_S1 instance = new Y2020M11D25_LC_Q1143_S1();

        // "horse", "ros"
        // "abcde", "ace"
        // "abc", "abc"
        // "abc", "def"
        // "qaqcde", "aced"
        // "aqafgh", "ahfph"

        System.out.println(instance.longestCommonSubsequence("horse", "ros"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1.length() - 1, text2.length() - 1, text1, text2);
    }

    /**
     * 对于两个字符串的动态规划问题, 大部分情况下有一个通用的解决思路:
     * 用两个指针 i & j 分别指向两个字符串的最后一个字符, 然后一步步往前走, 缩小问题的规模
     * <p>
     * 在本题中, 需要求出两个字符串的最长公共子序列的长度
     * 因此, 当指针 i & j 分别指向两个字符串中的字符 text1[i] & text2[j] 时, 会有两种情况:
     * <p>
     * 1.如果 text1[i] == text2[j], 说明字符 text1[i] (text2[j]) 必定为字符串 text1 在区间[0, i] 和 字符串 text2 在区间[0, j] 的最长公共子序列的最后一个字符
     * 此时 最长公共子序列的长度 应当加 1, 且指针 i & j 同时前移一位
     * <p>
     * 2.如果 text1[i] != text2[j], 说明字符 text1[i] 和 字符 text2[j] 至少有一个不在 最长公共子序列 当中
     * <p>
     * 如果假设字符 text1[i] 不在 最长公共子序列 当中, 此时应当前移指针 i
     * 如果假设字符 text2[j] 不在 最长公共子序列 当中, 此时应当前移指针 j
     * 如果假设字符 text1[i] 和 字符 text2[j] 都不在 最长公共子序列 当中, 此时应当同时前移指针 i & j
     * <p>
     * 为了知道进行哪一种操作, 可以得到最长公共子序列, 那么每种操作都需要尝试一遍
     * <p>
     * 于是定义函数 longestCommonSubsequence(i, j, text1, text2), 其中 -1 <= i <= text1.length - 1, -1 <= j <= text2.length - 1
     * 返回 text1 在区间 [0, i] 和 text2 在区间 [0, j] 的最长公共子序列的长度
     * <p>
     * 如果进行的操作是前移指针 i, 那么 最长公共子序列的长度 = longestCommonSubsequence(i - 1, j, text1, text2)
     * <p>
     * 如果进行的操作是前移指针 j, 那么 最长公共子序列的长度 = longestCommonSubsequence(i, j - 1, text1, text2)
     * <p>
     * 如果进行的操作是同时前移指针 i & j, 那么 最长公共子序列的长度 = longestCommonSubsequence(i - 1, j - 1, text1, text2)
     * <p>
     * 特别地, 当 i == -1 时, text1 在区间 [0, -1] 不存在字符, 此时 text1 是一个空字符串
     * 空字符串 与 任意字符串 的 最长公共子序列的长度 必定为 0
     * <p>
     * 同理, 当 j == -1 时, text2 与 任意字符串 的 最长公共子序列的长度 必定为 0
     * <p>
     * 综上所述, 可得出结论:
     * <p>
     * 当 text1[i] == text2[j] 时,
     * text1 在区间 [0, i] 和 text2 在区间 [0, j] 的最长公共子序列的长度 =
     * 1 + longestCommonSubsequence(i - 1, j - 1, text1, text2)
     * <p>
     * 当 text1[i] != text2[j] 时,
     * text1 在区间 [0, i] 和 text2 在区间 [0, j] 的最长公共子序列的长度 =
     * max(longestCommonSubsequence(i - 1, j, text1, text2),
     * longestCommonSubsequence(i, j - 1, text1, text2),
     * longestCommonSubsequence(i - 1, j - 1, text1, text2))
     */
    public int longestCommonSubsequence(int i, int j, String text1, String text2) {
        if (i >= 0 && j >= 0) {
            if (text1.charAt(i) == text2.charAt(j)) {
                return 1 + longestCommonSubsequence(i - 1, j - 1, text1, text2);
            } else {
                int max = 0;
                max = Math.max(max, longestCommonSubsequence(i - 1, j, text1, text2));
                max = Math.max(max, longestCommonSubsequence(i, j - 1, text1, text2));
                max = Math.max(max, longestCommonSubsequence(i - 1, j - 1, text1, text2));
                return max;
            }
        }
        return 0;
    }
}
