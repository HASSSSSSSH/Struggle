package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s, 找到 s 中最长的回文子串
 * 你可以假设 s 的最大长度为 1000
 * <p>
 * 实例1:
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 * <p>
 * 实例2:
 * 输入: "babad"
 * 输出: "bb"
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.DynamicProgramming}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}
 * <p>
 * 时间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * 空间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * Different implementation of {@link Y2020M12D03_LC_Q5_S5}
 */
public class Y2020M12D03_LC_Q5_S10 {

    public static void main(String args[]) {
        Y2020M12D03_LC_Q5_S10 instance = new Y2020M12D03_LC_Q5_S10();

        // babad
        // fffffffffffffffffffggggggggggggggggggggg
        // abzdba
        // cccbbccd
        // cbabxdaad
        // cbabxdaadz
        // abcdxddcba

        System.out.println(instance.longestPalindrome("cccbbccd"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] arr = new boolean[n][n];
        // 事实上没必要初始化arr[i][i], 因为当子串长度为3时, 不需要通过arr[j + 1][j + i - 1]判断是否是回文字符串
        // for (int i = 0; i < n; i++) {
        //     arr[i][i] = true;
        // }
        int start = 0;
        int end = 1;

        // 1.按不同的子串长度[2, n]进行填表, (i + 1)实际上代表了子串的长度
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < n - i; j++) {
        //         // 当子串长度 <= 3时, 只需判断左右两边的字符是否相等
        //         if ((i < 3 || arr[j + 1][j + i - 1]) && s.charAt(j) == s.charAt(j + i)) {
        //             arr[j][j + i] = true;
        //             if ((i + 1) > (end - start)) {
        //                 start = j;
        //                 end = j + i + 1;
        //             }
        //         }
        //     }
        // }

        // 2.按列[1, n)进行填表, 第i列有i个元素, 顺序填充[0, i)每一行的元素
        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j < i; j++) {

        // 3.按列[1, n)进行填表, 第i列有i个元素, 倒序填充(i, 0]每一行的元素
        // for (int i = 1; i < n; i++) {
        //     for (int j = i - 1; j >= 0; j--) {
        //         // 当子串长度(i - j + 1) <= 3时, 只需判断左右两边的字符是否相等
        //         if (((i - j + 1) <= 3 || arr[j + 1][i - 1]) && s.charAt(j) == s.charAt(i)) {
        //             arr[j][i] = true;
        //             if ((i - j + 1) > (end - start)) {
        //                 start = j;
        //                 end = i + 1;
        //             }
        //         }
        //     }
        // }

        // 4.按行[n - 1, 0]倒序填表, 第i行有(n - i - 1)个元素, 顺序填充[i + 1, n - 1]每一列的元素
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                // 5.按行[n - 1, 0]倒序填表, 第i行有(n - i - 1)个元素, 倒序填充[n - 1, i + 1]每一列的元素
                // for (int i = n - 1; i >= 0; i--) {
                //     for (int j = n - 1; j >= i + 1; j--) {
                // 当子串长度(j - i + 1) <= 3时, 只需判断左右两边的字符是否相等
                if (((j - i + 1) <= 3 || arr[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    arr[i][j] = true;
                    if ((j - i + 1) > (end - start)) {
                        start = i;
                        end = j + 1;
                    }
                }
            }
        }

        return s.substring(start, end);
    }
}
