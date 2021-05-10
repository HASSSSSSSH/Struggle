package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix, 请按照顺时针螺旋顺序, 返回矩阵中的所有元素
 * <p>
 * 提示:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * Tags: {@link questions.tags.Array}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(mn), 其中 m 和 n 分别是输入矩阵的行数和列数, 矩阵中的每个元素都要被访问一次
 * <p>
 * 空间复杂度: O(1), 除了输出数组以外, 空间复杂度是常数
 */
public class Y2021M03D19_LC_Q54_S1 {

    public static void main(String args[]) {
        Y2021M03D19_LC_Q54_S1 instance = new Y2021M03D19_LC_Q54_S1();

        // new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}
        // new int[][]{{1, 2}, {3, 4}}
        // new int[][]{{1}}
        // new int[][]{{6, 9, 7}}

        System.out.println(instance.spiralOrder(new int[][]{{1}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        // 如果矩阵中没有元素, 那么矩阵必定为 0 行 0 列
        // 如果矩阵中存在元素, 那么矩阵至少有 1 行 1 列
        if (matrix == null || matrix.length == 0) {
            return list;
        }

        int fromIndexX = 0;
        // 列数
        int toIndexX = matrix[0].length - 1;

        int fromIndexY = 0;
        // 行数
        int toIndexY = matrix.length - 1;

        // 设矩阵中剩余元素的行数为 m, 列数为 n
        // 只有当 m >= 1, n >= 1 时, 剩余元素的数量 > 0
        // 所以必须满足 (fromIndexX <= toIndexX && fromIndexY <= toIndexY)
        while (fromIndexX <= toIndexX && fromIndexY <= toIndexY) {
            int column, row;

            // 从坐标点 (fromIndexX, fromIndexY) 到坐标点 (toIndexX, fromIndexY)
            for (column = fromIndexX; column <= toIndexX; column++) {
                list.add(matrix[fromIndexY][column]);
            }

            // 从坐标点 (toIndexX, fromIndexY + 1) 到坐标点 (toIndexX, toIndexY - 1)
            for (row = fromIndexY + 1; row < toIndexY; row++) {
                list.add(matrix[row][toIndexX]);
            }

            // 如果 toIndexY == fromIndexY, 即矩阵中剩余元素的行数 m = 1, 说明经过上面两次遍历之后, 所有剩余元素都已经被遍历
            // 只有当矩阵中剩余元素的行数 m > 1 时, 即 (fromIndexY < toIndexY) 满足时, 才有以下逻辑
            if (fromIndexY < toIndexY) {
                // 从坐标点 (toIndexX, toIndexY) 到坐标点 (fromIndexX, toIndexY)
                for (column = toIndexX; column >= fromIndexX; column--) {
                    list.add(matrix[toIndexY][column]);
                }
            }

            // 如果 toIndexX == fromIndexX, 即矩阵中剩余元素的列数 n = 1, 说明经过上面两次遍历之后, 所有剩余元素都已经被遍历
            // 只有当矩阵中剩余元素的列数 n > 1 时, 即 (fromIndexX < toIndexX) 满足时, 才有以下逻辑
            if (fromIndexX < toIndexX) {
                // 从坐标点 (fromIndexX, toIndexY - 1) 到坐标点 (fromIndexX, fromIndexY + 1)
                for (row = toIndexY - 1; row > fromIndexY; row--) {
                    list.add(matrix[row][fromIndexX]);
                }
            }

            fromIndexX++;
            toIndexX--;
            fromIndexY++;
            toIndexY--;
        }

        return list;
    }
}
