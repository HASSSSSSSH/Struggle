package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * 组合总和 Ⅳ
 * 给定一个由正整数组成且不存在重复数字的数组, 找出和为给定目标正整数的组合的个数
 * <p>
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * 所有可能的组合为:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * 请注意, 顺序不同的序列被视作不同的组合
 * 因此输出为 7
 * <p>
 * 进阶:
 * 如果给定的数组中含有负数会怎么样?
 * 问题会产生什么变化?
 * 我们需要在题目中添加什么限制来允许负数的出现?
 * <p>
 * Solution: Dynamic Programming
 * Reference:
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/377-zu-he-zong-he-iv-javascript-san-chong-jie-ti-s/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M09D21_LC_Q377_S3 {

    /**
     * 关于进阶问题的思考:
     * 如果给定的数组中含有负数会怎么样? 问题会产生什么变化? (注意到, 此时需要找出的目标数仍然为正整数)
     * 如果有负数, 相当于给定数组中的元素有了更多的组合, 特别是出现了一对相反数的时候,
     * 假设有数组 [-4, 1, 2, 3, 4], 当 target = 4 的时候, -4 和 4 可以无限次地, 成对添加到结果中, 成为新的组合, 那么这道问题就没有什么意义了
     * <p>
     * 仔细思考, 负数我只要不选它就行了
     * 但由于这道问题的问法是 组合 , 因此我们要保证有负数参与进来, 不能够与已有的正数的组合之和为 0 即可
     * <p>
     * 我们需要在题目中添加什么限制来允许负数的出现?
     * 如果有负数参与进来, 不能够与已有的正数的组合之和为 0
     * 或者限制负数的使用次数, 设计成类似 0-1 背包问题的样子
     */
    public static void main(String args[]) {
        Y2020M09D21_LC_Q377_S3 instance = new Y2020M09D21_LC_Q377_S3();
        // (new int[]{1, 2, 3}, 4)
        // (new int[]{1, 2, 3}, 6)
        // (new int[]{2, 1, 3}, 35)
        // (new int[]{3, 33, 333}, 10000)
        System.out.println(instance.combinationSum4(new int[]{3, 33, 333}, 10000));
    }

    /**
     * 输入数组的每个元素可以使用多次, 这一点和「完全背包」问题有点像
     * 顺序不同的序列被视作不同的组合, 这一点和所有的「背包问题」都不同, 与 LeetCode 518 不同的地方就在这一点
     * <p>
     * 遇到这一类问题, 做一件事情有很多种做法, 每一种做法有若干个步骤, 脑子里能想到的常规思路大概有「回溯搜索」,「动态规划」
     * 由于不用得到具体的组合表示, 因此考虑使用「动态规划」来解
     * <p>
     * 怎么写代码呢?
     * <p>
     * 递归求解:
     * 由于有大量「重复子问题」, 因此必须使用缓存, 以避免相同问题重复求解, 这个方法叫「记忆化搜索」
     * 在《算法导论》这本书上也把它归入到「动态规划」的定义中
     * 这种思考问题的方式是「从上到下」的, 直接面对问题求解, 遇到什么问题, 就解决什么问题, 同时记住结果
     * <p>
     * 「动态规划」告诉了我们另一种思考问题的方式:
     * 「从底向上」, 可以不直接面对问题求解, 从这个问题最小的样子开始, 通过逐步递推, 至到得到所求的问题的答案
     * <p>
     * 虽然这个问题没有明显的「最优子结构」, 但这种「从底向上」递推的思路是很深刻的
     * <p>
     * 动态规划的两个步骤是思考 状态 以及 状态转移方程
     * 状态:
     * dp[i]: 对于给定的由正整数组成且不存在重复数字的数组, 和为 i 的组合的个数
     * 状态转移方程:
     * 由树形图(见 https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/), 可以很容易地写出状态转移方程
     * dp[i] = sum{dp[i - num] for num in nums and if i >= num}, 其中 nums 为给定的由正整数组成且不存在重复数字的数组
     * <p>
     * 特别地, 当 i = num 时, 有 dp[0] = 1, 表示如果 nums 里有一个数恰好等于 target, 它单独成为 1 种可能
     * <p>
     * 显然, 这个问题适合通过 自底向上 的递推思路去解决
     */
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            dp[i] = 0;
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
