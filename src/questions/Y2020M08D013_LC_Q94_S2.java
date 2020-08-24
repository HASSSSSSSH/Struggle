package questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历
 * 给定一个二叉树, 返回它的中序遍历
 * <p>
 * Solution: Iterative
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M08D013_LC_Q94_S2 {

    public static void main(String args[]) {
        Y2020M08D013_LC_Q94_S2 instance = new Y2020M08D013_LC_Q94_S2();
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
        if (root != null) {
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            stack.offer(root);
            TreeNode top;
            while ((top = stack.peekLast()) != null) {
                if (top.left != null) {
                    stack.offer(top.left);
                    top.left = null;
                    continue;
                }

                res.add(top.val);
                stack.pollLast();
                if (top.right != null) {
                    stack.offer(top.right);
                }
            }
        }
        return res;
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
