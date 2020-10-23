package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 * 零钱兑换 II
 * 给定不同面额的硬币和一个总金额
 * 写出函数来计算可以凑成总金额的硬币组合数, 假设每一种面额的硬币有无限个
 * <p>
 * 事例:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释:
 * 有四种方式可以凑成总金额
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * Solution: Depth First Search & Backtracking
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 组合可以存在重复元素
 * 解集不包含重复组合
 * 顺序不同的序列被视作相同的组合
 * 只需要输出组合数, 不需要输出具体解集
 * 候选数组元素都是正整数
 * 目标数target不一定是正整数
 * <p>
 * Result: TimeOut
 */
public class Y2020M09D27_LC_Q518_S1 {

    public static void main(String args[]) {
        Y2020M09D27_LC_Q518_S1 instance = new Y2020M09D27_LC_Q518_S1();
        // (5, new int[]{1, 2, 5})
        System.out.println(instance.change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] answer = new int[]{0};
        backtrack(answer, 0, coins, amount);
        return answer[0];
    }

    public void backtrack(int[] ans, int begin, int[] coins, int target) {
        if (target == 0) {
            ans[0]++;
            return;
        }
        for (int i = begin; i < coins.length; i++) {
            if (target - coins[i] < 0) {
                break;
            }
            backtrack(ans, i, coins, target - coins[i]);
        }
    }

    // public int change(int amount, int[] coins) {
    //     Arrays.sort(coins);
    //     List<List<Integer>> answer = new ArrayList<>();
    //     backtrack(answer, new ArrayList<>(), 0, coins, amount);
    //     return answer.size();
    // }
    //
    // public void backtrack(List<List<Integer>> ans, List<Integer> combine, int begin, int[] coins, int target) {
    //     if (target == 0) {
    //         ans.add(new ArrayList<>(combine));
    //         return;
    //     }
    //     for (int i = begin; i < coins.length; i++) {
    //         if (target - coins[i] < 0) {
    //             break;
    //         }
    //         combine.add(coins[i]);
    //         backtrack(ans, combine, i, coins, target - coins[i]);
    //         combine.remove(combine.size() - 1);
    //     }
    // }
}
