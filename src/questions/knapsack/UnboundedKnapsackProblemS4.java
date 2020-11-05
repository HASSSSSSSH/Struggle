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
 */
public class UnboundedKnapsackProblemS4 {

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

        UnboundedKnapsackProblemS4 instance = new UnboundedKnapsackProblemS4();
        System.out.println(instance.solution(W, weights, values));
    }

    /**
     * 这种解法相较于 {@link UnboundedKnapsackProblemS3}
     * 事实上是两个 for循环 中语句的对调
     * 虽然都能得出正确的结果, 但是这种解法事实上会有重复的计算(存在重复组合的计算)
     * <p>
     * 在计算组合的最大值(最小值)时, 这种解法得出的结果是正确
     * 因为结果要求的是组合的最大值(最小值), 只要计算过程正确遍历所有组合, 即使有对重复组合进行计算, 也能得出正确的最大值(最小值)
     * <p>
     * 但是在计算组合总数时 {@link questions.Y2020M11D02_LC_Q518_S8}
     * 由于此解法存在重复组合的计算, 所以无法得出正确结果
     */
    public int solution(int capacity, int[] weights, int[] values) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= capacity; i++) {
            int max = 0;
            for (int j = 0; j < weights.length; j++) {
                if (weights[j] <= i) {
                    max = Math.max(max, dp[i - weights[j]] + values[j]);
                }
            }
            dp[i] = max;
        }
        return dp[capacity];
    }
}
