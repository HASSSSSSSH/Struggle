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
 * 空间复杂度: O(mn), 需要创建一个大小为 m * n 的数组 visited 记录每个位置上的元素是否被访问过
 */
public class Y2021M03D24_LC_Q54_S2 {

    public static void main(String args[]) {
        Y2021M03D24_LC_Q54_S2 instance = new Y2021M03D24_LC_Q54_S2();

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

        // 行数
        int rows = matrix.length;

        // 列数
        int columns = matrix[0].length;

        int total = rows * columns;

        int row = 0;
        int column = 0;

        boolean[][] visited = new boolean[rows][columns];

        // directions.length = 4, 表示了 4 个方向: 往右, 往下, 往左, 往上
        // directions[directionIndex][0] 表示在第 directionIndex 个方向上 y 的增量
        // directions[directionIndex][1] 表示在第 directionIndex 个方向上 x 的增量
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            list.add(matrix[row][column]);
            visited[row][column] = true;

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];

            // 注意, 需要判断 4 种越界的情况: 右越界, 下越界, 左越界, 上越界
            // 同时, 这种遍历方式会导致重复遍历同一个元素, 需要引入额外的空间记录元素是否已被访问
            if (nextRow >= rows || nextColumn >= columns || nextRow < 0 || nextColumn < 0
                    || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % directions.length;
                nextRow = row + directions[directionIndex][0];
                nextColumn = column + directions[directionIndex][1];
            }

            row = nextRow;
            column = nextColumn;
        }

        return list;
    }
}
