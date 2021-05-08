package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * 二叉树的层序遍历
 * <p>
 * 给你一个二叉树, 请你返回其按 层序遍历 得到的节点值
 * 即逐层地, 从左到右访问所有节点
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}, {@link questions.tags.BreadthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.BreadthFirstSearch}, {@link questions.tags.HashTable}
 * <p>
 * Reference: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2021M01D08_LC_Q102_S1 {

    public static void main(String args[]) {
        Y2021M01D08_LC_Q102_S1 instance = new Y2021M01D08_LC_Q102_S1();

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

        System.out.println(instance.levelOrder(treeNode));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        // 维护一个 map, 表示某个节点和它所在的层数
        HashMap<TreeNode, Integer> mapping = new HashMap<>();
        mapping.put(root, 1);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            int level = mapping.get(node);

            // 根据节点的层数, 将其值加入到对应的列表当中
            if (ans.size() >= level) {
                ans.get(level - 1).add(node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                ans.add(list);
            }

            if (node.left != null) {
                deque.offerLast(node.left);
                // 子节点的层数 = 父节点的层数 + 1
                mapping.put(node.left, level + 1);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
                // 子节点的层数 = 父节点的层数 + 1
                mapping.put(node.right, level + 1);
            }
        }
        return ans;
    }
}
