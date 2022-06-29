package problems.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * 两个数组的交集
 * <p>
 * 给定两个数组 nums1 和 nums2, 返回它们的交集, 输出结果中的每个元素一定是 唯一 的
 * 我们可以不考虑输出结果的顺序
 * <p>
 * 示例 1:
 * 输入: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
 * 输出: [2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
 * 输出: [9, 4]
 * 解释: [4, 9] 也是可通过的
 * <p>
 * 提示:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * Tags:
 * {@link questions.tags.Array}, {@link questions.tags.HashTable}, {@link questions.tags.TwoPointers}
 * {@link questions.tags.BinarySearch}, {@link questions.tags.Sorting}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: O(m + n), 其中 m 和 n 分别是两个数组的长度
 * <p>
 * 空间复杂度: O(m + n), 其中 m 和 n 分别是两个数组的长度, 空间复杂度主要取决于两个集合
 */
public class Num349_Solution1 {

    public static void main(String[] args) {
        Num349_Solution1 instance = new Num349_Solution1();

        // new int[]{1, 2, 2, 1}, new int[]{2, 2}
        // new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}

        System.out.println(Arrays.toString(instance.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] ans = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            ans[index++] = integer;
        }
        return ans;
    }
}
