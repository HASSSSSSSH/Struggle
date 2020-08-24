package questions;

import utils.TreeUtils;
import utils.TreeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 不同的二叉搜索树 II
 * 给定一个整数 n, 生成所有由 1 ... n 为节点所组成的 二叉搜索树
 * <p>
 * 二叉搜索树的性质:
 * 1.根节点的值大于左子树所有节点的值, 小于右子树所有节点的值
 * 2.左子树和右子树也同样为二叉搜索树
 * <p>
 * Solution: dynamic programming
 * <p>
 * 时间复杂度: ?
 * <p>
 * 空间复杂度: ?
 */
public class Y2020M08D020_LC_Q95_S2 {

    public static void main(String args[]) {
        Y2020M08D020_LC_Q95_S2 instance = new Y2020M08D020_LC_Q95_S2();
        List<TreeNode> res = instance.generateTrees(3);
        for (TreeNode node : res) {
            System.out.println(TreeUtils.preOrderTraversal(node));
        }
    }

    /**
     * 动态规划
     * 令dp[i][j] (i <= j), 表示所有由 i ... j 为节点所组成的二叉搜索树
     * 可得状态方程:
     * dp[i][j] = dp[i][x - 1] (左子树) + x (根节点) + dp[x + 1][j] (右子树), x为可能的根节点, 且 x ∈ [i, j]
     * 当 i > j 时, 意味着不存在由 i ... j 为节点所组成的二叉树, dp[i][j] = null
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        List<List<List<TreeNode>>> dp = new ArrayList<>();

        // dp[n + 2][n + 1] make all things simpler
        // 由于dp[i][j]表示所有由 i ... j 为节点所组成的二叉搜索树
        // 而状态方程的计算过程中, 涉及到 dp[i][i - 1] 和 dp[j + 1][j] 的计算
        // 为了简化计算过程, 令原本 n * n 的二维数组转化为 (n + 2) * (n + 1) 的二维数组
        // 其中 dp[i][i - 1] 使数组 index = 0 处增加一空列
        // dp[i][j] (i ∈ [1, n] , j ∈ [1, n], i <= j) 使数组 index = 0 处增加一空行
        // dp[j + 1][j] 使数组 index = n + 1 处增加一空行
        for (int i = 0; i < n + 2; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++) {
                dp.get(i).add(new ArrayList<>());
                if (i > j) {
                    // 当 i > j 时, 意味着不存在由 i ... j 为节点所组成的二叉树
                    // 但仍然需要将其作为一颗有效的子树, dp[i][j] = null
                    dp.get(i).get(j).add(null);
                }
            }
        }
        // for (int i = 0; i < n; i++) {
        //     dp.add(new ArrayList<>());
        //     for (int j = 0; j < n; j++) {
        //         dp.get(i).add(new ArrayList<>());
        //         if (j > i) {
        //             dp.get(i).get(j).add(null);
        //         }
        //     }
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                // 为 dp[j][j + i] 赋值
                int start = j;
                int end = j + i;
                for (int k = start; k <= end; k++) {
                    for (TreeNode left : dp.get(start).get(k - 1)) {
                        for (TreeNode right : dp.get(k + 1).get(end)) {
                            dp.get(j).get(j + i).add(new TreeNode(k, left, right));
                        }
                    }
                }
            }
        }
        return dp.get(1).get(n);
    }
}
