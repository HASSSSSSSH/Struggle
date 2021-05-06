package questions;

import utils.TreeUtils;
import utils.TreeUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * 根据一棵树的 前序遍历 与 中序遍历 构造二叉树
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
 * Reference: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n), 除去返回的答案需要的 O(n) 空间之外, 我们还需要使用 O(n) 的空间存储 HashMap, 以及 O(h) 的递归栈空间
 * 其中 h 是树的高度, 且 h < n, 所以总空间复杂度为 O(n)
 */
public class Y2020M12D10_LC_Q105_S1 {

    public static void main(String args[]) {
        Y2020M12D10_LC_Q105_S1 instance = new Y2020M12D10_LC_Q105_S1();

        // new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}

        System.out.println(TreeUtils.preOrderTraversal(
                instance.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})));
    }

    private int[] preorder;
    // private int[] inorder;
    // private Map<Integer, Integer> preorderMapping = new HashMap<>();
    private Map<Integer, Integer> inorderMapping = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        int n = preorder.length;

        //
        for (int i = 0; i < n; i++) {
            inorderMapping.put(inorder[i], i);
        }

        //
        return buildTree(0, n - 1, 0, n - 1);
    }

    /**
     *
     */
    public TreeNode buildTree(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        //
        if (preorderLeft > preorderRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderLeft]);

        int inorderIndex = inorderMapping.get(preorder[preorderLeft]);
        int leftNodeNum = inorderIndex - inorderLeft;
        int rightNodeNum = inorderRight - inorderIndex;

        //
        root.left = buildTree(preorderLeft + 1, preorderLeft + leftNodeNum,
                inorderLeft, inorderIndex - 1);

        //
        root.right = buildTree(preorderLeft + leftNodeNum + 1, preorderLeft + leftNodeNum + rightNodeNum,
                inorderIndex + 1, inorderRight);

        return root;
    }
}
