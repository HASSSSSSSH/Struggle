package questions;

import utils.TreeUtils;
import utils.TreeUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 从中序与后序遍历序列构造二叉树
 * <p>
 * 根据一棵树的 中序遍历 与 后序遍历 构造二叉树
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}, {@link questions.tags.Array}, {@link questions.tags.DepthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Recursive}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n), 除去返回的答案需要的 O(n) 空间之外, 我们还需要使用 O(n) 的空间存储 HashMap, 以及 O(h) 的递归栈空间
 * 其中 h 是树的高度, 且 h < n, 所以总空间复杂度为 O(n)
 */
public class Y2020M12D15_LC_Q106_S1 {

    public static void main(String args[]) {
        Y2020M12D15_LC_Q106_S1 instance = new Y2020M12D15_LC_Q106_S1();

        // new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}

        System.out.println(TreeUtils.preOrderTraversal(
                instance.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3})));
    }

    // private int[] inorder;
    private int[] postorder;
    private Map<Integer, Integer> inorderMapping = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // this.inorder = inorder;
        this.postorder = postorder;

        int n = inorder.length;

        for (int i = 0; i < n; i++) {
            inorderMapping.put(inorder[i], i);
        }
        return buildTree(0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {
        if (postorderLeft > postorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorderRight]);
        int inorderIndex = inorderMapping.get(postorder[postorderRight]);
        int leftNodeNum = inorderIndex - inorderLeft;
        int rightNodeNum = inorderRight - inorderIndex;

        // postorderRight = postorderRight - rightNodeNum - 1 = postorderLeft + leftNodeNum - 1
        root.left = buildTree(inorderLeft, inorderIndex - 1,
                postorderLeft, postorderLeft + leftNodeNum - 1);

        root.right = buildTree(inorderIndex + 1, inorderRight,
                postorderRight - rightNodeNum, postorderRight - 1);

        return root;
    }
}
