package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * 二叉树的层序遍历 II
 * <p>
 * 给你 一个二叉树 和 一个目标值, 如果能够找到该目标值, 则返回二叉树在该层序上按 层序遍历 得到的节点值
 * 否则返回空列表
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
public class Y2021M01D11_LC_Q102_1_S1 {

    public static void main(String args[]) {
        Y2021M01D11_LC_Q102_1_S1 instance = new Y2021M01D11_LC_Q102_1_S1();

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

        System.out.println(instance.solution(treeNode, 7));
    }

    public List<Integer> solution(TreeNode root, int target) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        // 至关重要!
        // 当队列中保存的节点全部都是 NullTreeNode 时, hasNext = false
        // 说明树的最后一层已经遍历完成, 下一层已经没有其他元素
        boolean hasNext = true;

        // 广度优先遍历
        // 必须要判断 hasNext
        while (!deque.isEmpty() && hasNext) {
            // 重置标志位, 因为不确定树是否存在下一层
            hasNext = false;

            // 注意, 需要首先保存 当前队列中元素的数量
            // 此时, 树在当前层序的元素数量 = 当前队列中元素的数量
            // 在遍历中, 队列中元素的数量 不一定等于 树在当前层序的元素的剩余数量
            int levelSize = deque.size();

            // 标记是否已经找到目标元素
            boolean targetFound = false;

            // 遍历树在当前层序上的每一个节点, 包括空节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.pollFirst();

                if (node instanceof NullTreeNode) {
                    // 当遇到 NullTreeNode 时, 往线性表中添加 null
                    list.add(null);
                } else {
                    list.add(node.val);

                    if (node.val == target) {
                        // 找到目标元素
                        // 注意, 由于要输出树在这一层序上所有的元素, 所以需要遍历完这一层序上所有的元素
                        targetFound = true;
                    }
                }

                if (node.left != null) {
                    deque.offerLast(node.left);

                    // 至关重要, 标记树仍存在下一层元素
                    hasNext = true;
                } else {
                    // NullTreeNode 表示 一个空节点, 在遍历中遇到 NullTreeNode 时, 往线性表中添加 null
                    // 注意到, 如果 node 为 NullTreeNode 时, 也会进入此分支
                    deque.offerLast(new NullTreeNode());
                }

                if (node.right != null) {
                    deque.offerLast(node.right);

                    // 至关重要, 标记树仍存在下一层元素
                    hasNext = true;
                } else {
                    // NullTreeNode 表示 一个空节点, 在遍历中遇到 NullTreeNode 时, 往线性表中添加 null
                    // 注意到, 如果 node 为 NullTreeNode 时, 也会进入此分支
                    deque.offerLast(new NullTreeNode());
                }
            }

            if (targetFound) {
                // 已经找到目标元素
                // 此时已经遍历完当前层序上所有的元素, 直接返回线性表
                return list;
            } else {
                // 遍历完当前层序上所有的元素仍然没有找到目标值, 清空线性表
                list.clear();
            }
        }
        return list;
    }

    // 如果往 ArrayDeque 中加入 null, 会抛出空指针异常
    // 因此, 通过一个继承 TreeNode 的类的实例表示一个空的节点
    private static class NullTreeNode extends TreeNode {
    }
}
