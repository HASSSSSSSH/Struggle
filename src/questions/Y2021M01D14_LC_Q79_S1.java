package questions;

/**
 * https://leetcode-cn.com/problems/word-search/
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 单词搜索
 * <p>
 * 给定一个二维网格和一个单词, 找出该单词是否存在于网格中
 * 单词必须按照字母顺序, 通过相邻的单元格内的字母构成, 其中 "相邻" 单元格是那些水平相邻或垂直相邻的单元格
 * 同一个单元格内的字母不允许被重复使用
 * <p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * 提示:
 * board 和 word 中只包含大写和小写英文字母
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.Backtracking}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Backtracking}, {@link questions.tags.DepthFirstSearch}
 * <p>
 * 时间复杂度: 一个非常宽松的上界为 O(M * N * 3L), 其中 M, N 为网格的长度与宽度, L 为字符串 word 的长度
 * 参考 https://leetcode-cn.com/problems/word-search/solution/dan-ci-sou-suo-by-leetcode-solution/
 * <p>
 * 空间复杂度: O(M * N), 我们额外开辟了 O(M * N) 的 visited 数组, 同时栈的深度最大为 O(min(L, MN))
 */
public class Y2021M01D14_LC_Q79_S1 {

    public static void main(String args[]) {
        Y2021M01D14_LC_Q79_S1 instance = new Y2021M01D14_LC_Q79_S1();

        // new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABC"
        // new char[][]{{'A'}}, "A"

        System.out.println(instance.exist(new char[][]{{'A'}}, "A"));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        // 标识字符 board[i][j] 是否被访问过
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 注意, 从字符 board[i][j] 开始深度优先遍历, 如果无法匹配整个字符串 word, 数组 visited 会被回溯到没有选择任何字符时的状态
                // 从字符 board[i][j] 开始深度优先遍历, 如果无法匹配整个字符串 word, 数组 visited 可以直接复用, 此时 visited 数组中的元素都为 false
                if (backtrack(board, i, j, visited, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, boolean[][] visited, char[] word, int index) {
        if (visited[i][j]) {
            // 字符 board[i][j] 已经被使用, 直接返回 false
            return false;
        }

        if (word[index] == board[i][j]) {
            // 字符 board[i][j] 能够匹配字符 word[index], 继续尝试

            if (index == word.length - 1) {
                // 最后一个字符已经匹配, 直接返回 true
                // 否则进入下面的逻辑之后, 会错误地返回 false
                return true;
            }

            // 标记字符 board[i][j] 已经被使用
            visited[i][j] = true;

            // leftward
            if (i - 1 >= 0 && backtrack(board, i - 1, j, visited, word, index + 1)) {
                return true;
            }

            // rightward
            if (i + 1 < board.length && backtrack(board, i + 1, j, visited, word, index + 1)) {
                return true;
            }

            // up
            if (j - 1 >= 0 && backtrack(board, i, j - 1, visited, word, index + 1)) {
                return true;
            }

            // down
            if (j + 1 < board[0].length && backtrack(board, i, j + 1, visited, word, index + 1)) {
                return true;
            }

            // 在选择字符 board[i][j] 以后, 无法匹配后续的字符
            // 回溯到没有选择字符 board[i][j] 时的状态
            visited[i][j] = false;
        }

        return false;
    }
}
