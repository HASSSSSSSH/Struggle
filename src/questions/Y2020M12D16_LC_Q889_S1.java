package questions;

import utils.TreeUtils;
import utils.TreeUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * 根据前序和后序遍历构造二叉树
 * <p>
 * 根据一棵树的 前序遍历 与 后序遍历 构造二叉树
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}
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
public class Y2020M12D16_LC_Q889_S1 {

    public static void main(String args[]) {
        Y2020M12D16_LC_Q889_S1 instance = new Y2020M12D16_LC_Q889_S1();

        // new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}

        System.out.println(TreeUtils.preOrderTraversal(
                instance.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1})));
    }

    private int[] pre;
    // private int[] post;
    private Map<Integer, Integer> mapping = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        this.pre = pre;

        for (int i = 0; i < post.length; i++) {
            mapping.put(post[i], i);
        }
        return buildTree(0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int preorderLeft, int preorderRight, int postorderLeft, int postorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preorderLeft]);

        int leftNodeNum = 0;
        if (preorderLeft + 1 <= preorderRight) {
            int leftIndex = mapping.get(pre[preorderLeft + 1]);
            leftNodeNum = leftIndex - postorderLeft + 1;
            root.left = buildTree(preorderLeft + 1, preorderLeft + leftNodeNum,
                    postorderLeft, leftIndex);
        } else {
            root.left = null;
        }

        int rightNodeNum = 0;
        if (preorderLeft + leftNodeNum + 1 <= preorderRight) {
            // int rightIndex = mapping.get(pre[preorderLeft + leftNodeNum + 1]);
            rightNodeNum = preorderRight - preorderLeft - leftNodeNum;
            root.right = buildTree(preorderLeft + leftNodeNum + 1, preorderRight,
                    postorderRight - rightNodeNum, postorderRight - 1);
        } else {
            root.right = null;
        }

        return root;
    }
}
