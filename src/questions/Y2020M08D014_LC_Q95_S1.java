package questions;

import java.util.ArrayList;
import java.util.List;

import utils.TreeUtils;
import utils.TreeUtils.TreeNode;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 不同的二叉搜索树 II
 * 给定一个整数 n, 生成所有由 1 ... n 为节点所组成的 二叉搜索树
 * <p>
 * 二叉搜索树的性质:
 * 1.根节点的值大于左子树所有节点的值, 小于右子树所有节点的值
 * 2.左子树和右子树也同样为二叉搜索树
 * <p>
 * Solution: Recursive
 * Reference: https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
 * <p>
 * 时间复杂度: O(4^n / n^(1/2))
 * 整个算法的时间复杂度取决于「可行二叉搜索树的个数」, 而对于 n 个点生成的二叉搜索树数量等价于数学上第 n 个「卡特兰数」, 用 Gn 表示
 * 卡特兰数具体的细节请读者自行查询, 这里不再赘述, 只给出结论
 * 生成一棵二叉搜索树需要 O(n) 的时间复杂度, 一共有 Gn 棵二叉搜索树, 也就是O(n Gn)
 * 而卡特兰数以 4^n / n^(3/2) 增长, 因此总时间复杂度为 O(4^n / n^(1/2))
 * <p>
 * 空间复杂度: O(4^n / n^(1/2))
 * n 个点生成的二叉搜索树有 Gn 棵, 每棵有 n 个节点
 * 因此存储的空间需要 O(n Gn) = O(4^n / n^(1/2))
 * 递归函数需要 O(n) 的栈空间, 因此总空间复杂度为 O(4^n / n^(1/2))
 */
public class Y2020M08D014_LC_Q95_S1 {

    public static void main(String args[]) {
        Y2020M08D014_LC_Q95_S1 instance = new Y2020M08D014_LC_Q95_S1();
        List<TreeNode> res = instance.generateTrees(3);
        for (TreeNode node : res) {
            System.out.println(TreeUtils.preOrderTraversal(node));
        }
    }

    /**
     * 在生成所有可行的二叉搜索树的时候, 假设当前序列长度为 n, 如果我们枚举根节点的值为 i
     * 那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为 [1, 2, 3, ..., i − 1], 右子树的节点值的集合为 [i + 1, i + 2 , ..., n]
     * 而左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题, 因此我们可以想到用递归的方法来解决这道题目
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    /**
     * 定义 generateTrees(start, end) 函数, 表示当前值的集合为 [start, end], 返回生成的所有可行的二叉搜索树
     * 遍历 [start, end], 设 i 为当前二叉搜索树的根的值, 那么序列可以划分为 [start, i − 1] 和 [i + 1, end] 两部分
     * 递归调用这两部分, 即 generateTrees(start, i - 1) 和 generateTrees(i + 1, end), 便可以获得所有可行的左子树和可行的右子树
     */
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (start > end) {
            // 递归的出口, 意味着[start, end]之间不存在可行的二叉搜索树

            // 不可省略, 因为 nodeList.add(null), nodeList.size() = 1 代表着根节点仍然存在着一颗有效的子树
            nodeList.add(null);

            return nodeList;
        }
        for (int i = start; i <= end; i++) {
            // 生成所有可能的左子树
            List<TreeNode> leftNodeList = generateTrees(start, i - 1);

            // 生成所有可能的右子树
            List<TreeNode> rightNodeList = generateTrees(i + 1, end);

            for (TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    // 拼接以i为值的根节点
                    nodeList.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }
        return nodeList;
    }
}
