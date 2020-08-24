package questions;

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
 * Reference: https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n^2)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M08D024_LC_Q96_S3 {

    public static void main(String args[]) {
        Y2020M08D024_LC_Q96_S3 instance = new Y2020M08D024_LC_Q96_S3();
        System.out.println(instance.numTrees(3));
    }

    public int numTrees(int n) {
        if (n < 1) {
            return 1;
        }
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += (G[j - 1] * G[i - j]);
            }
        }
        return G[n];
    }
}
