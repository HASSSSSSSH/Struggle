package problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * 螺旋矩阵 II
 * <p>
 * 给你一个正整数 n, 生成一个包含 1 到 n^2 所有元素, 且元素按顺时针顺序螺旋排列的 n * n 正方形矩阵 matrix
 * <p>
 * 示例 1:
 * 输入: n = 3
 * 输出: [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
 * <p>
 * 示例 2:
 * 输入: n = 1
 * 输出: [[1]]
 * <p>
 * 提示:
 * 1 <= n <= 20
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.Matrix}, {@link questions.tags.Simulation}
 * <p>
 * Solution: {@link questions.tags.Simulation}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n), 其中 n 是给定的正整数
 * 矩阵的大小是 n * n, 需要填入矩阵中的每个元素
 * <p>
 * 空间复杂度: O(1), 除了返回的矩阵以外, 空间复杂度是常数
 */
public class Num59_Solution1 {

    public static void main(String[] args) {
        Num59_Solution1 instance = new Num59_Solution1();

        // 3
        // 1

        System.out.println(Arrays.deepToString(instance.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }

        int square = n * n;
        int[][] matrix = new int[n][n];
        // 填充的初始位置, 为了方便进行第一次填充, 初始化为 {0, -1}
        int[] index = new int[]{0, -1};
        // 定义按顺时针填充的方向: 右 -> 下 -> 左 -> 上
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // directions[curDirection] 表示当前的填充方向
        int curDirection = 0;

        // 填充 n * n 的矩阵
        for (int i = 1; i <= square; i++) {
            int[] direction = directions[curDirection];
            int[] nextIndex = new int[]{index[0] + direction[0], index[1] + direction[1]};

            // 首先判断目标位置是否会导致数组越界
            if (nextIndex[0] < 0 || nextIndex[0] >= n || nextIndex[1] < 0 || nextIndex[1] >= n ||
                    // 判断目标位置是否已经访问过
                    // 由于填入矩阵的元素均为正数, 如果目标位置的元素值大于 0, 说明已经访问过此位置
                    matrix[nextIndex[0]][nextIndex[1]] > 0) {
                // 改变填充方向
                curDirection = (curDirection + 1) % directions.length;
                direction = directions[curDirection];
                nextIndex = new int[]{index[0] + direction[0], index[1] + direction[1]};
            }
            index = nextIndex;
            matrix[index[0]][index[1]] = i;
        }

        return matrix;
    }
}
