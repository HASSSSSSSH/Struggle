package questions.knapsack;

/**
 * 有一个​能承受最大重量为 W 的背包和 N 件物品, 物品 i 的重量为 wi, 价格为 vi, 每件物品都有无限件可用
 * 求将哪些物品装入背包, 可使这些物品的总体积不超过背包容量, 且总价值最大, 输出最大价值
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * Reference: https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * <p>
 * 时间复杂度: O(N * W^2), N 为物品种数, W 为背包容量
 * <p>
 * 空间复杂度: O(N * W)
 * <p>
 * 分析:
 * 1.为什么是 完全背包 问题
 * 每种物品都有无限件可用
 * 背包容量有限制
 * 具体组合是顺序无关的
 */
public class UnboundedKnapsackProblemS1 {

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

        UnboundedKnapsackProblemS1 instance = new UnboundedKnapsackProblemS1();
        System.out.println(instance.solution(W, weights, values));
    }

    /**
     * 动态规划
     * <p>
     * Step 1.定义状态
     * dp[i][j]: 在不超过背包容量 j 的前提下, 物品在前缀子区间 [0, i] 能够获得的最大价值
     * <p>
     * Step 2.状态转移方程
     * 遍历到的每一种物品, 逐个考虑添加到 总价值 中
     * 由于物品的个数可以无限选取, 因此对于一种新的物品 ni
     * 依次考虑选取 0 件, 1 件, 2 件, ..., k 件, 直到选取这件物品的总金额超过背包容量 j 为止
     * 但是, 需要满足: j - k * weights[i] >= 0
     * 当选取了 k 件物品 ni 时, 从 [0, i - 1] 区间选取物品, 尝试去填满剩余背包的剩余容量 j - k * weights[i]
     * 所以在选取了 k 件物品 ni 时, 能够获得的最大价值 = dp[i - 1][j - k * coins[i]] + k * values[i]
     * <p>
     * 可得状态转移方程:
     * dp[i][j] = max(dp[i - 1][j - k * weights[i]] + k * values[i]), 其中 j - k * weights[i] >= 0, 0 <= k <= j / weights[i]
     * <p>
     * Step 4.思考输出
     * 输出的结果应该是: 在不超过背包容量 capacity 的前提下, 物品在区间 [0, length - 1] 能够获得的最大价值
     * 输出就是表格的最后一格的数值, 即 dp[length - 1][capacity]
     */
    public int solution(int capacity, int[] weights, int[] values) {
        int length = weights.length;
        int[][] dp = new int[length][capacity + 1];

        // 初始化二维数组第一行, 此时只需要考虑第一件物品 n0
        // 需要注意 dp[i][j] 的定义是: 在不超过背包容量 j 的前提下, 物品在前缀子区间 [0, i] 能够获得的最大价值
        // 所以当 k * weights[0] < capacity 时, 此时得到的结果也是一个有效的值
        for (int k = weights[0]; k <= capacity; k++) {
            dp[0][k] = k / weights[0] * values[0];
        }

        // 从区间 [0, 1] 开始
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= capacity; j++) {
                // k 需要从 0 开始
                // 在不超过背包容量 j 的前提下, 考虑从物品区间 [0, i] 中选取物品
                // 有可能在不选取物品 ni 的情况下, 能够获得的最大价值
                int k = 0;

                // 能够获得的最大价值
                int max = 0;

                while (k * weights[i] <= j) {
                    max = Math.max(max, dp[i - 1][j - k * weights[i]] + k * values[i]);
                    k++;
                }
                dp[i][j] = max;
            }
        }
        return dp[length - 1][capacity];
    }
}
