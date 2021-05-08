package questions;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 机器人的运动范围
 * <p>
 * 地上有一个 m 行 n 列的方格, 从坐标 [0, 0] 到坐标 [m - 1, n - 1]
 * 一个机器人从坐标 [0, 0] 的格子开始移动, 它每次可以向左, 右, 上, 下移动一格 (不能移动到方格外), 也不能进入行坐标和列坐标的数位之和大于 k 的格子
 * 例如, 当 k 为 18 时, 机器人能够进入方格 [35, 37], 因为 3 + 5 + 3 + 7 = 18
 * 但它不能进入方格 [35, 38], 因为 3 + 5 + 3 + 8 = 19
 * 请问该机器人能够到达多少个格子?
 * <p>
 * 示例 1:
 * 输入: m = 2, n = 3, k = 1
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: m = 3, n = 1, k = 0
 * 输出: 1
 * <p>
 * 提示:
 * 1 <= n, m <= 100
 * 0 <= k <= 20
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.Backtracking}, {@link questions.tags.DepthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Backtracking}, {@link questions.tags.DepthFirstSearch}
 * <p>
 * Reference: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(m * n), 其中 m 为方格的行数, n 为方格的列数
 * 考虑所有格子都能进入, 那么搜索的时候一个格子最多会被访问的次数为常数, 所以时间复杂度为 O(2 * m * n) = O(m * n)
 * <p>
 * 空间复杂度: O(m * n), 其中 m 为方格的行数, n 为方格的列数
 * 搜索的时候需要一个大小为 O(m * n) 的标记结构用来标记每个格子是否被走过
 * <p>
 * Optimization of {@link Y2021M01D15_LCOF_Q13_S1}
 */
public class Y2021M01D15_LCOF_Q13_S2 {

    public static void main(String args[]) {
        Y2021M01D15_LCOF_Q13_S2 instance = new Y2021M01D15_LCOF_Q13_S2();

        // 2, 3, 1
        // 3, 1, 0
        // 3, 3, 3

        System.out.println(instance.movingCount(3, 3, 3));
    }

    public int movingCount(int m, int n, int k) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[] ans = new int[]{0};
        dfs(ans, 0, 0, new boolean[m][n], m, n, k);
        return ans[0];
    }

    /**
     * 事实上, 在搜索的过程中搜索方向可以缩减为向右和向下, 不需要再向上和向左进行搜索
     * 因为随着限制条件 k 的增大, (0, 0) 所在的蓝色方格区域内新加入的非障碍方格都可以由上方或左方的格子移动一步得到
     * 而其他不连通的蓝色方格区域会随着 k 的增大而连通, 且连通的时候也是由上方或左方的格子移动一步得到, 因此我们可以将我们的搜索方向缩减为向右或向下
     */
    public void dfs(int[] ans, int i, int j, boolean[][] visited, int m, int n, int k) {
        if (visited[i][j]) {
            return;
        }
        if (getValue(i, j) <= k) {
            ans[0]++;
            visited[i][j] = true;

            if (i + 1 < m) {
                dfs(ans, i + 1, j, visited, m, n, k);
            }
            if (j + 1 < n) {
                dfs(ans, i, j + 1, visited, m, n, k);
            }
        }
    }

    public int getValue(int i, int j) {
        int value = 0;
        while (i != 0) {
            value += i % 10;
            i = i / 10;
        }
        while (j != 0) {
            value += j % 10;
            j = j / 10;
        }
        return value;
    }
}
