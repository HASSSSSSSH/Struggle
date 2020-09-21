package questions;

import utils.TreeUtils.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 * 给定一个二叉树, 检查它是否是镜像对称的
 * <p>
 * Solution: Recursive
 * Reference: https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 * 这里的空间复杂度和递归使用的栈空间有关, 这里递归层数不超过n
 * 故渐进空间复杂度为 O(n)
 */
public class Y2020M08D28_LC_Q101_S2 {

    public static void main(String args[]) {
        Y2020M08D28_LC_Q101_S2 instance = new Y2020M08D28_LC_Q101_S2();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(2);
        System.out.println(instance.isSymmetric(treeNode1));
    }

    public boolean isSymmetric(TreeNode root) {
        // also right
        // return isSymmetric(root, root);

        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && isSymmetric(p.left, q.right)
                && isSymmetric(p.right, q.left);
    }
}
