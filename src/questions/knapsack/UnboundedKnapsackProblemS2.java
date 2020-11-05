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
 * 空间复杂度: O(N * W)
 * <p>
 * 分析:
 * 1.为什么是 完全背包 问题
 * 每种物品都有无限件可用
 * 背包容量有限制
 * 具体组合是顺序无关的
 * <p>
 * Optimization of {@link UnboundedKnapsackProblemS1}
 */
public class UnboundedKnapsackProblemS2 {

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

        UnboundedKnapsackProblemS2 instance = new UnboundedKnapsackProblemS2();
        System.out.println(instance.solution(W, weights, values));
    }

    /**
     * 优化状态转移方程
     * <p>
     * 由状态转移方程:
     * dp[i][j] = max(dp[i - 1][j - k * weights[i]] + k * values[i]), 其中 j - k * weights[i] >= 0, 0 <= k <= j / weights[i]
     * 将 k = 0 作为一个单独比较项, 得:
     * dp[i][j]
     * = max(dp[i - 1][j], dp[i - 1][j - k * weights[i]] + k * values[i]), 式(1)
     * 其中 1 <= k <= j / weights[i]
     * <p>
     * 又有
     * dp[i - 1][j - k * weights[i]] + k * values[i]
     * = (dp[i - 1][j - k * weights[i]] + (k - 1) * values[i]) + values[i], 式(2)
     * <p>
     * 令 x = j - weights[i]
     * 由状态转移方程可得:
     * dp[i][x] = max(dp[i - 1][x - k' * weights[i]] + k' * values[i]), 其中 x - k' * weights[i] >= 0, 0 <= k' <= x / weights[i]
     * 即:
     * dp[i][j - weights[i]]
     * = max(dp[i - 1][j - weights[i] - k' * weights[i]] + k' * values[i])
     * = max(dp[i - 1][j - (k' + 1) * weights[i]] + k' * values[i])
     * 其中 j - weights[i] - k' * weights[i] = j - (k' + 1) * weights[i] >= 0
     * <p>
     * 又有 j - k * weights[i] >= 0
     * 所以 k' < k, k' + 1 = k
     * <p>
     * 将 k' + 1 = k 代入 dp[i][j - weights[i]] = max(dp[i - 1][j - (k' + 1) * weights[i]] + k' * values[i])
     * 得
     * dp[i][j - weights[i]]
     * = max(dp[i - 1][j - k * weights[i]] + (k - 1) * values[i]), 式(3)
     * <p>
     * 结合式子(1)(2)(3), 可得新的状态转移方程:
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - weights[i]] + values[i]), j - weights[i] >= 0
     */
    public int solution(int capacity, int[] weights, int[] values) {
        int length = weights.length;

        // 事实上, 在 dp[i][j] 的计算过程中
        // 只参考上一行 dp[i - 1][j'], j' ∈ [0, j] 的结果
        // 因此可以使用滚动数组, 只记录两行结果
        int[][] dp = new int[2][capacity + 1];

        // 初始化二维数组第一行, 此时只需要考虑第一件物品 n0
        // 需要注意 dp[i][j] 的定义是: 在不超过背包容量 j 的前提下, 物品在前缀子区间 [0, i] 能够获得的最大价值
        // 所以当 k * weights[0] < capacity 时, 此时得到的结果也是一个有效的值
        for (int k = weights[0]; k <= capacity; k++) {
            dp[0][k] = k / weights[0] * values[0];
        }

        // 从区间 [0, 1] 开始
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j - weights[i] >= 0) {
                    dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[i & 1][j - weights[i]] + values[i]);
                } else {
                    dp[i & 1][j] = dp[(i - 1) & 1][j];
                }
            }
        }
        return dp[(length - 1) & 1][capacity];
    }
}
