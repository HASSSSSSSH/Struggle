package problems.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/4sum-ii/
 * 四数相加 II
 * <p>
 * 给你四个整数数组 nums1, nums2, nums3 和 nums4, 数组长度都是 n
 * 请你计算有多少个元组 (i, j, k, l) 能满足:
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * 示例 1:
 * 输入: nums1 = [1, 2], nums2 = [-2, -1], nums3 = [-1, 2], nums4 = [0, 2]
 * 输出: 2
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 示例 2:
 * 输入: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出: 1
 * <p>
 * 提示:
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.HashTable}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(n^2), 我们使用了两次二重循环, 时间复杂度均为 O(n^2)
 * 在循环中对哈希映射进行的修改以及查询操作的期望时间复杂度均为 O(1), 因此总时间复杂度为 O(n^2)
 * <p>
 * 空间复杂度: O(n^2), 即为哈希映射需要使用的空间
 * 在最坏的情况下, nums1[i] + nums2[j] 的值均不相同, 因此值的个数为 n^2, 也就需要 O(n^2) 的空间
 * <p>
 * Reference: https://leetcode.cn/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
 */
public class Num454_Solution1 {

    public static void main(String[] args) {
        Num454_Solution1 instance = new Num454_Solution1();

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};

        // int[] nums1 = new int[]{0};
        // int[] nums2 = new int[]{0};
        // int[] nums3 = new int[]{0};
        // int[] nums4 = new int[]{0};

        System.out.println(instance.fourSumCount(nums1, nums2, nums3, nums4));
    }

    /**
     * 只要元组 (i, j, k, l) 满足 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0, 就算作一个有效的元组
     * 同时需要考虑数组中存在重复元素的情况
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        HashMap<Integer, Integer> mapAB = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                // dif 是 0 和 (a + b) 的差值
                int dif = -(a + b);

                // 使用 HashMap 记录 dif 的数量
                // 需要注意的是, 数组中可能包含重复元素, 所以 dif 的数量可能会大于 1
                mapAB.put(dif, mapAB.getOrDefault(dif, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;

                // 以 sum 作为 mapAB 的 key, 令 val = mapAB.getOrDefault(sum, 0)
                // 如果 val > 0, 说明存在 val 个元组满足要求
                ans += mapAB.getOrDefault(sum, 0);
            }
        }

        return ans;
    }

    // 超时的解法
    // public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    //     int ans = 0;
    //     int n = nums1.length;
    //     HashMap<Integer, Integer[]> hashMap = new HashMap<>();
    //
    //     for (int i = 0; i < n; i++) {
    //         Integer[] val = hashMap.getOrDefault(nums4[i], new Integer[]{});
    //         Integer[] newVal = new Integer[val.length + 1];
    //
    //         int index = 0;
    //         for (int a : val) {
    //             newVal[index++] = a;
    //         }
    //         newVal[index] = i;
    //         hashMap.put(nums4[i], newVal);
    //     }
    //
    //     for (int i = 0; i < n; i++) {
    //         int num1 = nums1[i];
    //         for (int j = 0; j < n; j++) {
    //             int num2 = nums2[j];
    //             for (int k = 0; k < n; k++) {
    //                 int num3 = nums3[k];
    //                 int dif = -(num1 + num2 + num3);
    //                 if (hashMap.containsKey(dif)) {
    //                     Integer[] val = hashMap.get(dif);
    //                     ans += val.length;
    //                 }
    //             }
    //         }
    //     }
    //
    //     return ans;
    // }
}
