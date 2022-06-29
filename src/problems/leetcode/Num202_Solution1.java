package problems.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/happy-number/
 * 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数
 * <p>
 * 「快乐数」定义为:
 * 对于一个正整数, 每一次将该数替换为它每个位置上的数字的平方和
 * 然后重复这个过程直到这个数变为 1, 也可能是 无限循环 但始终变不到 1
 * 如果这个过程结果为 1, 那么这个数就是快乐数
 * <p>
 * 如果 n 是快乐数就返回 true
 * 不是, 则返回 false
 * <p>
 * 示例 1:
 * 输入: n = 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 示例 2:
 * 输入: n = 2
 * 输出: false
 * <p>
 * 提示: 1 <= n <= 2^31 - 1
 * <p>
 * Tags: {@link questions.tags.HashTable}, {@link questions.tags.Math}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: O(log n)
 * <p>
 * 空间复杂度: O(log n)
 * <p>
 * Reference: https://leetcode.cn/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
 */
public class Num202_Solution1 {

    public static void main(String[] args) {
        Num202_Solution1 instance = new Num202_Solution1();

        // 19
        // 2

        System.out.println(instance.isHappy(2));
    }

    /**
     * 如果一个正整数是快乐数, 那么反复将该数替换为它每个位置上的数字的平方和, 最终数值会变为 1
     * <p>
     * 如果这个正整数不是快乐数, 这个过程需要考虑两种情况:
     * 1. 无限循环, 数值始终变不到 1
     * 2. 数值会越来越大, 最后接近无穷大
     * 实际上, 可以证明第 2 种情况完全不需要考虑
     * 参考自 https://leetcode.cn/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
     * <p>
     * 可以考虑使用 HashSet 记录每次得到的数值
     * 如果某个数值重复出现, 说明这个过程只会无限循环, n 不是快乐数
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int base = n % 10;
                sum += base * base;
                n = n / 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }

        return true;
    }
}
