package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * N 皇后
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上, 并且使皇后彼此之间不能相互攻击
 * 给你一个整数 n, 返回所有不同的 n 皇后问题 的解决方案
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案, 该方案中 'Q' 和 '.' 分别代表了皇后和空位
 * <p>
 * 提示:
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击, 也就是说: 任何两个皇后都不能处于同一条横行, 纵行或斜线上
 * <p>
 * Tags: {@link questions.tags.Backtracking}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Backtracking}, {@link questions.tags.DepthFirstSearch}
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 */
public class Y2021M01D27_LC_Q51_S1 {

    public static void main(String args[]) {
        Y2021M01D27_LC_Q51_S1 instance = new Y2021M01D27_LC_Q51_S1();

        System.out.println(instance.solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), 0, new boolean[n], n);
        return ans;
    }

    public void dfs(List<List<String>> ans, List<String> list, int row, boolean columnVisited[], int n) {
        if (row == n) {
            // 在回溯算法中, list 最终会变成空列表
            // 在存放到容器之前, 需要深度拷贝 list
            List<String> copy = new ArrayList<>(list);
            ans.add(copy);
        }

        // 初始化属于 row 这一行的字符数组
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }

        outer:
        // 遍历每一纵行
        for (int column = 0; column < n; column++) {

            // 假设当前纵行放置了一个皇后, 判断是否存在同一纵行上的皇后
            if (columnVisited[column]) {
                // 当前纵行已存在皇后, 继续 outer 循环
                continue;
            }

            // 假设当前纵行放置了一个皇后, 判断是否存在同一条斜线上的皇后
            for (int r = 0; r < row; r++) {
                int distance = row - r;
                if ((column - distance) >= 0 && 'Q' == list.get(r).charAt(column - distance)) {
                    continue outer;
                }
                if ((column + distance) < n && 'Q' == list.get(r).charAt(column + distance)) {
                    continue outer;
                }
            }

            // 当前纵行可以放置一个皇后, 设置状态
            columnVisited[column] = true;
            chars[column] = 'Q';
            list.add(String.valueOf(chars));

            // 对下一行进行 dfs, 因此同一条横行上总是只有一个皇后
            dfs(ans, list, row + 1, columnVisited, n);

            // 回溯到这一纵行没有放置皇后时的状态
            columnVisited[column] = false;
            chars[column] = '.';
            list.remove(list.size() - 1);
        }
    }
}
