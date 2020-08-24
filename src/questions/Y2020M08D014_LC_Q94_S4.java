package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历
 * 给定一个二叉树, 返回它的中序遍历
 * <p>
 * Solution: 莫里斯遍历
 * Reference: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
 * <p>
 * 时间复杂度: O(n)
 * 想要证明时间复杂度是O(n), 最大的问题是找到每个节点的前驱节点的时间复杂度
 * 乍一想, 找到每个节点的前驱节点的时间复杂度应该是 O(nlogn), 因为找到一个节点的前驱节点和树的高度有关
 * 但事实上, 找到所有节点的前驱节点只需要 O(n) 时间
 * 一棵 n 个节点的二叉树只有 n-1 条边, 每条边只可能使用2次, 一次是定位节点, 一次是找前驱节点
 * 故复杂度为 O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M08D014_LC_Q94_S4 {

    public static void main(String args[]) {
        Y2020M08D014_LC_Q94_S4 instance = new Y2020M08D014_LC_Q94_S4();
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
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode right = curr.left;
                while (right.right != null) {
                    right = right.right;
                }
                right.right = curr;
                curr = curr.left;
                right.right.left = null;
            } else {
                res.add(curr.val);
                curr = curr.right;
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
