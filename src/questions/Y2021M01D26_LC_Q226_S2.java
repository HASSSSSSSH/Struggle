package questions;

import utils.TreeUtils;
import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转二叉树
 * <p>
 * 翻转一棵二叉树
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * Reference: https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
 * <p>
 * 时间复杂度: O(N), 其中 N 为二叉树节点的数目
 * 我们会遍历二叉树中的每一个节点, 对每个节点而言, 我们在常数时间内交换其两棵子树
 * <p>
 * 空间复杂度: O(N), 使用的空间由当前节点在二叉树中的高度决定
 * 在平均情况下, 二叉树的高度与节点个数为对数关系, 即 O(logN)
 * 而在最坏情况下, 树形成链状, 空间复杂度为 O(N)
 */
public class Y2021M01D26_LC_Q226_S2 {

    public static void main(String args[]) {
        Y2021M01D26_LC_Q226_S2 instance = new Y2021M01D26_LC_Q226_S2();

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        System.out.println(TreeUtils.preOrderTraversal(instance.invertTree(tree)));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            TreeNode leftChild = node.left;
            node.left = node.right;
            node.right = leftChild;

            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }
        return root;
    }
}
