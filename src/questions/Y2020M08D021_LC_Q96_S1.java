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
 * Solution: Recursive
 * Result: Timeout
 * <p>
 * 时间复杂度: O(4^n / n^(1/2)), 类比{@link Y2020M08D014_LC_Q95_S1}
 * <p>
 * 空间复杂度: ?
 */
public class Y2020M08D021_LC_Q96_S1 {

    public static void main(String args[]) {
        Y2020M08D021_LC_Q96_S1 instance = new Y2020M08D021_LC_Q96_S1();
        System.out.println(instance.numTrees(18));
    }

    public int numTrees(int n) {
        return numTrees(1, n);
    }

    private int numTrees(int start, int end) {
        if (start > end) {
            return 1;
        }

        int total = 0;
        for (int i = start; i <= end; i++) {
            int leftCount = numTrees(start, i - 1);
            int rightCount = numTrees(i + 1, end);
            total += leftCount * rightCount;
        }
        return total;
    }
}
