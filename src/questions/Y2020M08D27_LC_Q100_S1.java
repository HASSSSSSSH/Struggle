package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * 相同的树
 * 给定两个二叉树, 编写一个函数来检验它们是否相同
 * 如果两个树在结构上相同, 并且节点具有相同的值, 则认为它们是相同的
 * <p>
 * Solution: Depth-First-Search
 * <p>
 * 时间复杂度: O(max(m, n)), 其中 m 和 n 分别是两个二叉树的节点数
 * <p>
 * 空间复杂度: O(m + n), 其中 m 和 n 分别是两个二叉树的节点数
 */
public class Y2020M08D27_LC_Q100_S1 {

    public static void main(String args[]) {
        Y2020M08D27_LC_Q100_S1 instance = new Y2020M08D27_LC_Q100_S1();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        System.out.println(instance.isSameTree(treeNode1, treeNode2));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> listP = new ArrayList<>();
        List<Integer> listQ = new ArrayList<>();
        preOrderTraversal(listP, p);
        preOrderTraversal(listQ, q);
        return listP.equals(listQ);
    }

    public static void preOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            list.add(null);
            return;
        }
        list.add(root.val);
        preOrderTraversal(list, root.left);
        preOrderTraversal(list, root.right);
    }
}
