package questions;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 编辑距离
 * 给你两个单词 word1 和 word2, 请你计算出将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作:
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示:
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * Solution: Brute force & Recursion
 * <p>
 * Reference: https://labuladong.github.io/ebook/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E7%BC%96%E8%BE%91%E8%B7%9D%E7%A6%BB.html
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Result: Time Limit Exceeded
 */
public class Y2020M11D20_LC_Q72_S1 {

    public static void main(String args[]) {
        Y2020M11D20_LC_Q72_S1 instance = new Y2020M11D20_LC_Q72_S1();

        // "horse", "ros"
        // "intention", "execution"
        // "rad", "apple"
        // "dinitrophenylhydrazine", "benzalphenylhydrazone"
        // "abc", ""

        System.out.println(instance.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        return minDistance(word1.length() - 1, word2.length() - 1, word1, word2);
    }

    /**
     * 对于两个字符串的动态规划问题, 大部分情况下有一个通用的解决思路:
     * 用两个指针 i & j 分别指向两个字符串的最后一个字符, 然后一步步往前走, 缩小问题的规模
     * <p>
     * 在本题中, 需要计算出将 word1 转换成 word2 所使用的最少操作数, 接下来将分两种情况讨论
     * <p>
     * 1.如果 word1[i] == word2[j], 在这种情况下, 为了得到最少的操作数, 应当直接跳过, 指针 i & j 同时前移一位
     * <p>
     * 2.如果 word1[i] != word2[j], 此时对于字符串 word1 有三种操作可选: 插入, 删除, 替换
     * 为了知道进行哪一种操作, 可以得到最少的操作数, 那么每种操作都需要尝试一遍
     * <p>
     * 于是定义函数 minDistance(i, j, word1, word2), 其中 -1 <= i <= word1.length - 1, -1 <= j <= word2.length - 1
     * 返回 word1 在区间 [0, i] 和 word2 在区间 [0, j] 的最小编辑距离
     * 即将 word1 在区间 [0, i] 转换成 word2 在区间 [0, j] 所使用的最少操作数
     * 其中 0 <= i <= word1.length - 1, 0 <= j <= word2.length - 1
     * <p>
     * 如果进行的操作是插入, 那么 最少的操作数 = minDistance(i, j - 1, word1, word2)
     * <p>
     * 如果进行的操作是删除, 那么 最少的操作数 = minDistance(i - 1, j, word1, word2)
     * <p>
     * 如果进行的操作是替换, 那么 最少的操作数 = minDistance(i - 1, j - 1, word1, word2)
     * <p>
     * 综上所述, 可得出结论:
     * <p>
     * 当 word1[i] == word2[j] 时, word1 在区间 [0, i] 和 word2 在区间 [0, j] 的最小编辑距离
     * = minDistance(i - 1, j - 1, word1, word2)
     * <p>
     * 当 word1[i] != word2[j] 时, word1 在区间 [0, i] 和 word2 在区间 [0, j] 的最小编辑距离
     * = 1 + min(minDistance(i, j - 1, word1, word2), minDistance(i - 1, j, word1, word2), minDistance(i - 1, j - 1, word1, word2))
     * 需要注意在三种操作(插入, 删除, 替换)中, 不论选择的是哪一种, 结果都需要加 1
     */
    public int minDistance(int index1, int index2, String word1, String word2) {
        while (index2 >= 0) {
            // 注意到这里是 while 语句

            // 事实上, 在不满足 (index1 >= 0 && word1.charAt(index1) == word2.charAt(index2)) 的情况下
            // 会中断 while 循环
            // 直接 return (1 + min(minDistance(i, j - 1, word1, word2), minDistance(i - 1, j, word1, word2), minDistance(i - 1, j - 1, word1, word2)))

            // 当 (index1 >= 0 && word1.charAt(index1) == word2.charAt(index2)) 成立时
            // 此时的下一个 while 循环, 事实上就相当于调用了 minDistance(i - 1, j - 1, word1, word2)

            if (index1 >= 0 && word1.charAt(index1) == word2.charAt(index2)) {
                index1--;
                index2--;
            } else {
                int min = Integer.MAX_VALUE;
                // insert
                min = Math.min(min, minDistance(index1, index2 - 1, word1, word2));

                if (index1 >= 0) {
                    // replace
                    min = Math.min(min, minDistance(index1 - 1, index2 - 1, word1, word2));
                    // delete
                    min = Math.min(min, minDistance(index1 - 1, index2, word1, word2));
                }
                return min + 1;
            }
        }

        // 当 index2 == 0 时, 说明字符串 word1 在区间 [index + 1, word1.length - 1] 已经转换成 word2
        // 如果此时 index1 >= 0, 说明字符串 word1 在区间 [0, index] 仍有多余的字符, 那么需要全部删除
        // 总共 index + 1 个删除操作
        return index1 >= 0 ? index1 + 1 : 0;
    }
}
