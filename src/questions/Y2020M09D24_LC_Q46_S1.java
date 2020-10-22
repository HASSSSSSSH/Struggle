package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 * 给定一个 没有重复 数字的序列, 返回其所有可能的全排列
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * Solution: Depth First Search & Backtracking
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组中的一个元素只能选取一次
 * 排列不存在重复元素
 * 解集不包含重复排列
 */
public class Y2020M09D24_LC_Q46_S1 {

    public static void main(String args[]) {
        Y2020M09D24_LC_Q46_S1 instance = new Y2020M09D24_LC_Q46_S1();
        // (new int[]{})
        // (new int[]{1, 2, 3})
        System.out.println(instance.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> arr = new ArrayList<>(nums.length);
        for (int num : nums) {
            arr.add(num);
        }
        dfs(answer, new ArrayList<>(nums.length), arr);
        return answer;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> permutation, List<Integer> nums) {
        if (nums.isEmpty()) {
            ans.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            // 从候选数组中删除 num
            nums.remove(i);
            // 选择 num , 将其加入到排列
            permutation.add(num);

            dfs(ans, permutation, nums);

            // 恢复 选择了num 之前的状态
            permutation.remove(permutation.size() - 1);
            nums.add(i, num);
        }
    }
}
