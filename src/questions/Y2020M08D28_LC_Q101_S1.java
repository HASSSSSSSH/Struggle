package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 * 给定一个二叉树, 检查它是否是镜像对称的
 * <p>
 * Solution: Breadth-First-Search
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M08D28_LC_Q101_S1 {

    public static void main(String args[]) {
        Y2020M08D28_LC_Q101_S1 instance = new Y2020M08D28_LC_Q101_S1();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.left.left = new TreeNode(2);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(2);
        System.out.println(instance.isSymmetric(treeNode1));
    }

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> deque = new ArrayList<>();
        deque.add(root);
        int levelSize;
        while (!deque.isEmpty()) {
            levelSize = deque.size();
            int start = 0;
            int end = levelSize - 1;
            while (start < end) {
                TreeNode left = deque.get(start++);
                TreeNode right = deque.get(end--);
                if (!(left == null && right == null) &&
                        (left == null || right == null || (left.val != right.val))) {
                    return false;
                }
            }
            // next level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.get(i);
                if (node != null) {
                    deque.add(node.left);
                    deque.add(node.right);
                }
            }
            deque.subList(0, levelSize).clear();
        }
        return true;
    }
}
