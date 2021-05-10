package questions;

import utils.TreeUtils.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 树的子结构
 * <p>
 * 输入两棵二叉树 A 和 B, 判断 B 是不是 A 的子结构 (约定空树不是任意一个树的子结构)
 * B 是 A 的子结构, 即 A 中有出现和 B 相同的结构和节点值
 * <p>
 * 限制:
 * 0 <= 节点个数 <= 10000
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}, {@link questions.tags.DepthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.DepthFirstSearch}
 * <p>
 * Reference: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 * <p>
 * 时间复杂度: O(MN), 其中 M, N 分别为树 A 和 树 B 的节点数量
 * 先序遍历树 A 占用 O(M), 每次调用 recur(A, B) 判断占用 O(N)
 * <p>
 * 空间复杂度: O(M), 当树 A 和树 B 都退化为链表时, 递归调用深度最大
 * 当 M <= N 时, 遍历树 A 与递归判断的总递归深度为 M
 * 当 M > N 时, 最差情况为遍历至树 A 叶子节点, 此时总递归深度为 M
 */
public class Y2021M01D26_LCOF_Q26_S1 {

    public static void main(String args[]) {
        Y2021M01D26_LCOF_Q26_S1 instance = new Y2021M01D26_LCOF_Q26_S1();

        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(1);

        System.out.println(instance.isSubStructure(tree1, tree2));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (recur(A, B)) {
            return true;
        }
        if (isSubStructure(A.left, B)) {
            return true;
        }
        if (isSubStructure(A.right, B)) {
            return true;
        }
        return false;
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
    }
}
