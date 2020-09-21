package questions;

import utils.TreeUtils.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * 相同的树
 * 给定两个二叉树, 编写一个函数来检验它们是否相同
 * 如果两个树在结构上相同, 并且节点具有相同的值, 则认为它们是相同的
 * <p>
 * Solution: Depth-First-Search
 * <p>
 * 时间复杂度: O(min(m, n)), 其中 m 和 n 分别是两个二叉树的节点数
 * 对两个二叉树同时进行深度优先搜索, 只有当两个二叉树中的对应节点都不为空时才会访问到该节点
 * 因此被访问到的节点数不会超过较小的二叉树的节点数
 * <p>
 * 空间复杂度: O(min(m, n)), 其中 m 和 n 分别是两个二叉树的节点数
 * 空间复杂度取决于递归调用的层数, 递归调用的层数不会超过较小的二叉树的最大高度
 * 最坏情况下, 二叉树的高度等于节点数
 */
public class Y2020M08D27_LC_Q100_S2 {

    public static void main(String args[]) {
        Y2020M08D27_LC_Q100_S2 instance = new Y2020M08D27_LC_Q100_S2();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        System.out.println(instance.isSameTree(treeNode1, treeNode2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
