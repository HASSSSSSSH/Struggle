package questions;

public class TNN07Day27 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0)
            return null;
        if (pre.length == 1)
            return new TreeNode(pre[0]);
        return construction(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    public TreeNode construction(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        TreeNode root = new TreeNode(pre[preStart]);
//        if (preStart == preEnd && inStart == inEnd && pre[preStart] == in[inStart]) {
//            return root;
//        }
        int inRootStart = inStart;
        for (; inRootStart <= inEnd; inRootStart++) {
            if (in[inRootStart] == root.val)
                break;
        }
        if (inRootStart > inEnd) {
            throw new IllegalStateException();
        }
        if (inRootStart > inStart) {
            root.left = construction(pre, in, preStart + 1, preStart + inRootStart - inStart,
                    inStart, inRootStart - 1);
        }
        if (inEnd > inRootStart) {
            root.right = construction(pre, in, preStart + inRootStart - inStart + 1, preEnd,
                    inRootStart + 1, inEnd);
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
