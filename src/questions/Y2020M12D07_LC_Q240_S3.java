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
 */
public class Y2020M12D07_LC_Q240_S3 {

    public static void main(String args[]) {
        Y2020M12D07_LC_Q240_S3 instance = new Y2020M12D07_LC_Q240_S3();

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

        // 假设二维数组是 {{-1}, {-1}}, 目标值为 -2
        // 由于 matrix.length > matrix[0].length
        // 当 start = 1 时, begin = 1, end = 1, mid = 1
        // matrix[1][1] 出现数组越界异常
        // for (int i = 0; i < matrix.length; i++) {

        // 需要计算行数和列数两者的最小值
        // 使用最小值就可以遍历整个数组
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
        if (vertical) {
            // start 的值是不能改变的
            // 此时 start 规定了垂直方向上的一列
            int begin = start;

            // end 从数组最后一个元素的 index 开始
            int end = matrix.length - 1;

            int mid = (end + begin) >> 1;

            // 条件 (begin < end) 在数组 [1, 2] 中查找 2 时, 会得出错误的答案
            // 条件 (begin < end) 应当改为 (begin <= end)
            // while (begin < end && matrix[mid][start] != target) {
            while (begin <= end && matrix[mid][start] != target) {
                if (matrix[mid][start] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }

                // 数组中间索引 mid 的错误计算方法
                // 应当为 mid = begin + ((end - begin) >> 1)
                // mid = (end - begin) >> 1;
                mid = (end + begin) >> 1;
            }

            // 当 begin = 0, end = 0 时, 如果 matrix[mid][start] > target, 此时 end = -1, 因此 mid = -1
            // 会出现数组越界异常
            // 不能通过 matrix[mid][start] == target 判断循环是否提前结束
            // return matrix[mid][start] == target;
            return begin <= end;
        } else {
            int begin = start;
            int end = matrix[0].length - 1;
            int mid = (end + begin) >> 1;

            // while (begin < end && matrix[start][mid] != target) {
            while (begin <= end && matrix[start][mid] != target) {
                if (matrix[start][mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }

                // mid = (end - begin) >> 1;
                mid = (end + begin) >> 1;
            }

            // return matrix[start][mid] == target;
            return begin <= end;
        }
    }
}
