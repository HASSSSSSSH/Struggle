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
 * 时间复杂度: O(m * n), 其中 m 为方格的行数, n 为方格的列数
 * 考虑所有格子都能进入, 那么搜索的时候一个格子最多会被访问的次数为常数, 所以时间复杂度为 O(m * n)
 * <p>
 * 空间复杂度: O(m * n), 其中 m 为方格的行数, n 为方格的列数
 * 搜索的时候需要一个大小为 O(m * n) 的标记结构用来标记每个格子是否被走过
 */
public class Y2021M01D15_LCOF_Q13_S1 {

    public static void main(String args[]) {
        Y2021M01D15_LCOF_Q13_S1 instance = new Y2021M01D15_LCOF_Q13_S1();

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

    public void dfs(int[] ans, int i, int j, boolean[][] visited, int m, int n, int k) {
        if (visited[i][j]) {
            return;
        }
        if (getValue(i, j) <= k) {
            ans[0]++;
            visited[i][j] = true;

            if (i - 1 >= 0) {
                dfs(ans, i - 1, j, visited, m, n, k);
            }
            if (i + 1 < m) {
                dfs(ans, i + 1, j, visited, m, n, k);
            }
            if (j - 1 >= 0) {
                dfs(ans, i, j - 1, visited, m, n, k);
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
