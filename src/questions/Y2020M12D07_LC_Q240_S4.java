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
 * Solution: Binary Search
 * <p>
 * Reference: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
 * <p>
 * 时间复杂度: O(lg(n!))
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Optimization of {@link Y2020M12D07_LC_Q240_S3}
 */
public class Y2020M12D07_LC_Q240_S4 {

    public static void main(String args[]) {
        Y2020M12D07_LC_Q240_S4 instance = new Y2020M12D07_LC_Q240_S4();

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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            if (binarySearch(i, true, matrix, target)) {
                return true;
            }
            if (binarySearch(i, false, matrix, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int start, boolean vertical, int[][] matrix, int target) {
        int low = start;
        int high = vertical ? matrix.length - 1 : matrix[0].length - 1;

        while (low <= high) {
            // same as java.util.Arrays#binarySearch0(int[], int, int, int)
            int mid = (low + high) >>> 1;

            if (vertical) {
                if (matrix[mid][start] > target) {
                    high = mid - 1;
                } else if (matrix[mid][start] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[start][mid] > target) {
                    high = mid - 1;
                } else if (matrix[start][mid] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
