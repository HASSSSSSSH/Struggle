package questions;

import java.util.ArrayList;

public class TNN07Day28 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        findPath(list, null, root, target, 0);
        return list;
    }

    public void findPath(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
                         TreeNode root, int target, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(root.val);

        // 找出路径
        if (currentSum == target && root.left == null && root.right == null) {
            ArrayList<Integer> l = new ArrayList<>(list);
            result.add(l);
        }

        findPath(result, list, root.left, target, currentSum);
        findPath(result, list, root.right, target, currentSum);

        if (list.size() != 0) {
            list.remove(list.size() - 1);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
