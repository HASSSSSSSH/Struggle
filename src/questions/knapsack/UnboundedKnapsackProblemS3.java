package questions.knapsack;

/**
 * 有一个​能承受最大重量为 W 的背包和 N 件物品, 物品 i 的重量为 wi, 价格为 vi, 每件物品都有无限件可用
 * 求将哪些物品装入背包, 可使这些物品的总体积不超过背包容量, 且总价值最大, 输出最大价值
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * Reference: https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * <p>
 * 时间复杂度: O(N * W), N 为物品种数, W 为背包容量
 * <p>
 * 空间复杂度: O(N)
 * <p>
 * 分析:
 * 1.为什么是 完全背包 问题
 * 每种物品都有无限件可用
 * 背包容量有限制
 * 具体组合是顺序无关的
 * <p>
 * Optimization of {@link UnboundedKnapsackProblemS2}
 */
public class UnboundedKnapsackProblemS3 {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int N = scanner.nextInt();
        // int W = scanner.nextInt();
        // int[] weights = new int[N];
        // int[] values = new int[N];
        // for (int i = 0; i < N; i++) {
        //     weights[i] = scanner.nextInt();
        //     values[i] = scanner.nextInt();
        // }

        // int W = 15;
        // int[] weights = new int[]{2, 4, 6};
        // int[] values = new int[]{3, 5, 7};

        // int W = 23;
        // int[] weights = new int[]{6, 20, 4};
        // int[] values = new int[]{18, 61, 8};

        int W = 23;
        int[] weights = new int[]{6, 10, 4};
        int[] values = new int[]{18, 31, 9};

        UnboundedKnapsackProblemS3 instance = new UnboundedKnapsackProblemS3();
        System.out.println(instance.solution(W, weights, values));
    }

    /**
     * 优化空间
     * <p>
     * 事实上, 在 dp[i][j] 的计算过程中
     * 只参考上一行 dp[i - 1][j] 的结果
     * 因此只需要使用一维数组
     */
    public int solution(int capacity, int[] weights, int[] values) {
        // 事实上, 在 dp[i][j] 的计算过程中
        // 只参考上一行 dp[i - 1][j] 的结果
        // 因此只需要使用一维数组
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < weights.length; i++) {

            // 无需 if (j - weights[i] >= 0), 直接从 weights[i] 开始
            for (int j = weights[i]; j <= capacity; j++) {
                // 状态方程
                // dp[i][j] = max(dp[i - 1][j], dp[i][j - weights[i]] + values[i]), j - weights >= 0
                // 然而在一维数组中, dp[j] 一开始的值实际上就等于 "上一行 dp[i - 1][j]" 的值

                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);

                // no need
                // if (j - weights[i] >= 0) {
                //     dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[i & 1][j - weights[i]] + values[i]);
                // } else {
                //     dp[i & 1][j] = dp[(i - 1) & 1][j];
                // }
            }
        }
        return dp[capacity];
    }
}
