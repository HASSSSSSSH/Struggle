package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点, 同一层的节点按照从左到右的顺序打印
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}, {@link questions.tags.BreadthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.BreadthFirstSearch}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2021M01D07_LCOF_Q32_1_S1 {

    public static void main(String args[]) {
        Y2021M01D07_LCOF_Q32_1_S1 instance = new Y2021M01D07_LCOF_Q32_1_S1();

        // level 1
        TreeNode treeNode = new TreeNode(1);
        // level 2
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        // level 3
        treeNode.left.left = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        // level 4
        treeNode.right.right.left = new TreeNode(7);

        System.out.println(Arrays.toString(instance.levelOrder(treeNode)));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
