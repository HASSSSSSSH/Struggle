package questions.longestCommonSubstring;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.nowcoder.com/questionTerminal/f0114dbcbf8e4180a4787eb159ee744c
 * 最长公共子串
 * 请编码实现一个命令行工具, 找出指定的2个字符串的最长公共子串
 * <p>
 * 输入描述:
 * 命令行工具接收两个字符串参数
 * 输入字符串的合法字符集为[a-z, A-Z, 0-9], 大小写敏感, 无需考虑异常输入场景
 * <p>
 * 输出描述:
 * 所有找到的公共子串
 * 如果存在多个等长的公共子串, 则请按字母序排序, 依次打印出所有公共子串, 每行一个
 * <p>
 * 示例1:
 * 输入: 1234567 12893457
 * 输出: 345
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * 时间复杂度: O(mn), 其中 m 为 text1 的长度, n 为 text2 的长度
 * <p>
 * 空间复杂度:  O(mn), 其中 m 为 text1 的长度, n 为 text2 的长度
 * 我们需要大小为 O(mn) 的数组来记录状态值
 */
public class LongestCommonSubstring2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        LongestCommonSubstring2 instance = new LongestCommonSubstring2();
        Set<String> ans = instance.longestCommonSubstring(s1, s2);

        for (String s : ans) {
            System.out.println(s);
        }
    }

    public Set<String> longestCommonSubstring(String text1, String text2) {
        // 字符比较次数
        int comparision = 0;

        int max = 0;
        TreeSet<String> set = new TreeSet<>();
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                comparision++;

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    if (dp[i + 1][j + 1] > max) {
                        // 当公共字符串的最大长度有更新时, 需要将集合中存储的字符串清空
                        set.clear();

                        // 已知公共字符串的长度以及结尾index
                        // 可以直接得出此公共字符串
                        set.add(text1.substring(i - dp[i + 1][j + 1] + 1, i + 1));

                        max = dp[i + 1][j + 1];
                    } else if (dp[i + 1][j + 1] == max) {
                        set.add(text1.substring(i - dp[i + 1][j + 1] + 1, i + 1));
                    }
                }
            }
        }
        return set;
    }
}

// public static void main(String args[]) {
//     LongestCommonSubstringS1 instance = new LongestCommonSubstringS1();
//     int[] result = new int[3];
//     System.out.println(instance.longestCommonSubstring("ab", "aab", result));
//     System.out.println("result[0]: " + result[0] + " result[1]: " + result[1] + " result[2]: " + result[2]);
// }
//
// public String longestCommonSubstring(String str1, String str2, int[] result) {
//     int start1 = -1;
//     int start2 = -1;
//     int length = 0;
//     int comparision = 0;
//     int k;
//     int l;
//     for (int i = 0; i < str1.length(); i++) {
//         for (int j = 0; j < str2.length(); j++) {
//             k = i;
//             l = j;
//             while (k < str1.length() && l < str2.length()) {
//                 comparision++;
//                 if (str1.charAt(k) != str2.charAt(l)) {
//                     break;
//                 }
//                 k++;
//                 l++;
//             }
//             if (length < k - i) {
//                 length = k - i;
//                 start1 = i;
//                 start2 = j;
//             }
//         }
//     }
//     System.out.println("comparision: " + comparision);
//     if (length > 0) {
//         result[0] = length;
//         result[1] = start1;
//         result[2] = start2;
//         return str1.substring(start1, start1 + length);
//     }
//     return "";
// }
