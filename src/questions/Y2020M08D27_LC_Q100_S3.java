package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * 相同的树
 * 给定两个二叉树, 编写一个函数来检验它们是否相同
 * 如果两个树在结构上相同, 并且节点具有相同的值, 则认为它们是相同的
 * <p>
 * Solution: Breadth-First-Search
 * <p>
 * 时间复杂度: O(min(m, n)), 其中 m 和 n 分别是两个二叉树的节点数
 * 对两个二叉树同时进行广度优先搜索, 只有当两个二叉树中的对应节点都不为空时才会访问到该节点
 * 因此被访问到的节点数不会超过较小的二叉树的节点数
 * <p>
 * 空间复杂度: O(min(m, n)), 其中 m 和 n 分别是两个二叉树的节点数
 * 空间复杂度取决于队列中的元素个数, 队列中的元素个数不会超过较小的二叉树的节点数
 */
public class Y2020M08D27_LC_Q100_S3 {

    public static void main(String args[]) {
        Y2020M08D27_LC_Q100_S3 instance = new Y2020M08D27_LC_Q100_S3();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        System.out.println(instance.isSameTree(treeNode1, treeNode2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> deque1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> deque2 = new ArrayDeque<>();
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            if ((p.left == null && q.left != null) || (p.left != null && q.left == null)) {
                return false;
            } else if (p.left != null) {
                deque1.offer(p.left);
                deque2.offer(q.left);
            }
            if ((p.right == null && q.right != null) || (p.right != null && q.right == null)) {
                return false;
            } else if (p.right != null) {
                deque1.offer(p.right);
                deque2.offer(q.right);
            }
            p = deque1.pollFirst();
            q = deque2.pollFirst();
        }
        return p == null && q == null;
    }
}
