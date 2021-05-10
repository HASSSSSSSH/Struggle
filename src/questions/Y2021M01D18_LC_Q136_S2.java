package questions;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 只出现一次的数字
 * <p>
 * 给定一个非空整数数组, 除了某个元素只出现一次以外, 其余每个元素均出现两次, 找出那个只出现了一次的元素
 * <p>
 * 说明:
 * 你的算法应该具有线性时间复杂度, 你可以不使用额外空间来实现吗?
 * 即时间复杂度为 O(n), 空间复杂度为 O(1)
 * <p>
 * Tags: {@link questions.tags.HashTable}, {@link questions.tags.BitManipulation}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.BitManipulation}
 * <p>
 * Reference: https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D18_LC_Q136_S2 {

    public static void main(String args[]) {
        Y2021M01D18_LC_Q136_S2 instance = new Y2021M01D18_LC_Q136_S2();

        // new int[]{2, 2, 1}
        // new int[]{4, 1, 2, 1, 2}

        System.out.println(instance.singleNumber(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
