package questions;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target
 * <p>
 * 该矩阵具有以下特性:
 * 每行的元素从左到右升序排列
 * 每列的元素从上到下升序排列
 * <p>
 * 示例 1:
 * 输入: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出: false
 * <p>
 * Solution: Brute force & Recursion
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2020M12D04_LC_Q240_S1 {

    public static void main(String args[]) {
        Y2020M12D04_LC_Q240_S1 instance = new Y2020M12D04_LC_Q240_S1();

        // new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
        //                 {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 30

        // new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
        //                 {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}}, 20

        // new int[][]{{1, 1}}, 2

        // new int[][]{{-1}, {-1}}, -2

        System.out.println(instance.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return matrix != null && matrix.length != 0 && matrix[0].length != 0
                && searchMatrix(0, 0, matrix, new boolean[matrix.length][matrix[0].length], target);
    }

    public boolean searchMatrix(int i, int j, int[][] matrix, boolean[][] visited, int target) {
        if (visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] > target) {
            if (i - 1 >= 0 && searchMatrix(i - 1, j, matrix, visited, target)) {
                return true;
            }
            if (j - 1 >= 0) {
                return searchMatrix(i, j - 1, matrix, visited, target);
            }
        } else {
            if (i + 1 < matrix.length && searchMatrix(i + 1, j, matrix, visited, target)) {
                return true;
            }
            if (j + 1 < matrix[0].length) {
                return searchMatrix(i, j + 1, matrix, visited, target);
            }
        }
        return false;
    }
}
