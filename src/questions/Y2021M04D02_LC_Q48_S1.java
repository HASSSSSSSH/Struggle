package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 * 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像, 请你将图像顺时针旋转 90 度
 * 你必须在 原地 旋转图像, 这意味着你需要直接修改输入的二维矩阵, 请不要 使用另一个矩阵来旋转图像
 * <p>
 * 提示:
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 * <p>
 * Tags: {@link questions.tags.Array}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n^2), 其中 n 是 matrix 的边长
 * <p>
 * 空间复杂度: O(n^2), 我们需要使用一个和 matrix 大小相同的辅助数组
 */
public class Y2021M04D02_LC_Q48_S1 {

    public static void main(String args[]) {
        Y2021M04D02_LC_Q48_S1 instance = new Y2021M04D02_LC_Q48_S1();

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] matrix = new int[][]{{1, 2}, {3, 4}};

        instance.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 当 n = 2 时, 有
     * array[0][1] = matrix[0][0]
     * array[1][1] = matrix[0][1]
     * array[0][0] = matrix[1][0]
     * array[1][0] = matrix[1][1]
     * <p>
     * 通过分析, 可得出规律: array[j][n - 1 - i] = matrix[i][j]
     * 以上规律对所有 n >= 1 都是满足的
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        int n = matrix.length;
        int[][] array = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                array[column][n - 1 - row] = matrix[row][column];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(array[i], 0, matrix[i], 0, n);
        }
    }
}
