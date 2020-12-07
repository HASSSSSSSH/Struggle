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
 * Solution: Iterative
 * <p>
 * Reference: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
 * <p>
 * 时间复杂度: O(n + m)
 * 时间复杂度分析的关键是: 注意到在每次迭代(不返回 true)时, 行或列都会精确地递减/递增一次
 * 由于行只能减少 m 次, 而列只能增加 n 次, 因此在 while 循环终止之前, 循环不能运行超过 n + m 次
 * 同时, 所有的其他的工作的时间复杂度都是常数, 所以总的时间复杂度在矩阵维数之和中是线性的
 * <p>
 * 空间复杂度: O(1), 因为这种方法只处理几个指针, 所以它的内存占用是恒定的
 */
public class Y2020M12D07_LC_Q240_S5 {

    public static void main(String args[]) {
        Y2020M12D07_LC_Q240_S5 instance = new Y2020M12D07_LC_Q240_S5();

        // new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
        //                 {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 30

        // new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
        //                 {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}}, 20

        // new int[][]{{1, 1}}, 2

        // new int[][]{{-1}, {-1}}, -2

        System.out.println(instance.searchMatrix(new int[][]{{-1}, {-1}}, -2));
    }

    /**
     * 首先, 我们初始化一个指向矩阵左下角的 (row，col) 指针
     * <p>
     * 当 matrix[row][column] != target 时, 会有以下两种情况:
     * <p>
     * 当 matrix[row][column] > target 时, 由于矩阵每行的元素从左到右升序排列
     * 当 column' > column 时, matrix[row][column'] > matrix[row][column] > target 总是成立
     * 说明矩阵第 (row + 1) 行的元素不可能等于 target
     * 因此, 指针应当向上移动一行
     * <p>
     * 当 matrix[row][column] < target 时, 由于矩阵每列的元素从上到下升序排列
     * 当 row' > row 时, matrix[row'][column] < matrix[row][column] < target 总是成立
     * 说明矩阵第 (column + 1) 列的元素不可能等于 target
     * 因此, 指针应当向右移动一行
     * <p>
     * 重复执行以上操作, 直至找到目标值 target 或者指针指向矩阵维度之外的 (row，col) 为止
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 指向矩阵的左下角
        int row = matrix.length - 1;
        int column = 0;

        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }
}
