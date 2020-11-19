package questions;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * 目标和
 * 给定一个非负整数数组, a1, a2, ..., an, 和一个目标数 S
 * 现在你有两个符号 + 和 -
 * 对于数组中的任意一个整数, 你都可以从 + 或 - 中选择一个符号添加在前面
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数
 * <p>
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 一共有5种方法让最终目标和为3
 * <p>
 * 提示:
 * 数组非空, 且长度不会超过 20
 * 初始的数组的和不会超过 1000
 * 保证返回的最终结果能被 32 位整数存下
 * <p>
 * Solution: Depth First Search & Backtrack
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Result: Wrong Answer
 */
public class Y2020M11D17_LC_Q494_S1 {

    public static void main(String args[]) {
        Y2020M11D17_LC_Q494_S1 instance = new Y2020M11D17_LC_Q494_S1();

        // new int[]{1, 1, 1, 1, 1}, 3
        // new int[]{1, 1, 2, 1, 1}, 3
        // new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1

        System.out.println(instance.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[] answer = new int[1];
        dfs(0, nums, 0, S, answer);
        return answer[0];
    }

    public void dfs(int begin, int[] nums, int sum, int target, int[] ans) {
        if (sum == target) {
            ans[0]++;
            return;
        }

        // 当 sum > target 时, 仍然有可能满足: 最终数组和 = 目标数S
        // if (sum > target) {
        //     return;
        // }

        for (int i = begin; i < nums.length; i++) {
            dfs(i + 1, nums, sum + nums[i], target, ans);
            dfs(i + 1, nums, sum - nums[i], target, ans);
        }
    }
}
