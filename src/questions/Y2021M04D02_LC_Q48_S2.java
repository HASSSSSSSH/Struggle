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
 * Reference: https://leetcode-cn.com/problems/rotate-image/solution/zi-wai-xiang-nei-shun-shi-zhen-xun-huan-jiao-huan-/
 * <p>
 * 时间复杂度: O(n^2), 其中 n 是 matrix 的边长
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M04D02_LC_Q48_S2 {

    public static void main(String args[]) {
        Y2021M04D02_LC_Q48_S2 instance = new Y2021M04D02_LC_Q48_S2();

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // int[][] matrix = new int[][]{{1, 2}, {3, 4}};

        instance.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }

        int n = matrix.length;

        // 沿垂直方向水平中线左右翻转
        // 相当于图像顺时针旋转 180°, 再沿水平方向中线上下翻转
        int start = 0;
        int end = n - 1;
        while (start < end) {
            for (int i = 0; i < n; i++) {
                int temp = matrix[i][end];
                matrix[i][end] = matrix[i][start];
                matrix[i][start] = temp;
            }
            start++;
            end--;
        }

        // 沿右上 - 左下的对角线翻转, 即交换 matrix[i][j] 和 matrix[n - 1 - j][n - 1 - i]
        // 相当于图像顺时针旋转 270°, 再沿垂直方向中线左右翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
    }
}
