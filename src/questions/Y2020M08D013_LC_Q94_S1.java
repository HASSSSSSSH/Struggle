package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历
 * 给定一个二叉树, 返回它的中序遍历
 * <p>
 * Solution: Recursive
 * <p>
 * 时间复杂度: O(n)
 * 递归函数 T(n) = 2 * T(n / 2) + 1
 * <p>
 * 空间复杂度: 最坏情况下需要空间O(n), 平均情况为O(log n)
 */
public class Y2020M08D013_LC_Q94_S1 {

    public static void main(String args[]) {
        Y2020M08D013_LC_Q94_S1 instance = new Y2020M08D013_LC_Q94_S1();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(6);
        treeNode.left.left.right.left = new TreeNode(7);
        treeNode.left.left.right.right = new TreeNode(8);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        System.out.println(instance.inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(res, root);
        return res;
    }

    public void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(list, root.left);
        list.add(root.val);
        inorderTraversal(list, root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
