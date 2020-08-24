package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 不同的二叉搜索树
 * 给定一个整数 n, 求以 1 ... n 为节点组成的二叉搜索树有多少种
 * <p>
 * 二叉搜索树的性质:
 * 1.根节点的值大于左子树所有节点的值, 小于右子树所有节点的值
 * 2.左子树和右子树也同样为二叉搜索树
 * <p>
 * Solution: dynamic programming
 * <p>
 * 时间复杂度:
 * <p>
 * 空间复杂度:
 */
public class Y2020M08D021_LC_Q96_S2 {

    public static void main(String args[]) {
        Y2020M08D021_LC_Q96_S2 instance = new Y2020M08D021_LC_Q96_S2();
        System.out.println(instance.numTrees(3));
    }

    public int numTrees(int n) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n + 2; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++) {
                if (i > j) {
                    // 当 i > j 时, 意味着不存在由 i ... j 为节点所组成的二叉树
                    // 但仍然需要将其作为一颗有效的子树, dp[i][j] = 1
                    dp.get(i).add(1);
                } else {
                    // 不可省略, 此处相当于初始化二维数组的列数
                    dp.get(i).add(0);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                // 为 dp[j][j + i] 赋值
                int start = j;
                int end = j + i;
                int count = 0;
                for (int k = start; k <= end; k++) {
                    count += dp.get(start).get(k - 1) * dp.get(k + 1).get(end);
                }
                dp.get(start).set(end, count);
            }
        }
        return dp.get(1).get(n);
    }
}
