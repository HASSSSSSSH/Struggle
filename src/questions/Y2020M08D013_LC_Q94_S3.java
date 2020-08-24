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
 * Reference: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M08D013_LC_Q94_S3 {

    public static void main(String args[]) {
        Y2020M08D013_LC_Q94_S3 instance = new Y2020M08D013_LC_Q94_S3();
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

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        // 当curr == null时, 说明上一个节点没有右节点, 接下来只需进行取出栈顶元素的操作
        while (curr != null || !stack.isEmpty()) {
            // left first
            while (curr != null) {
                // 注意: 需要将当前节点加入栈当中
                stack.offer(curr);
                curr = curr.left;
            }

            // 取出栈顶元素, 此时的元素必定满足中序遍历的要求
            curr = stack.pollLast();
            res.add(curr.val);

            // 此时curr必定无左节点, 接下来应该遍历curr的右节点
            curr = curr.right;
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
