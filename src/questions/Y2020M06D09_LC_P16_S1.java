package questions;

import java.util.Arrays;

public class Y2020M06D09_LC_P16_S1 {

    public static void main(String args[]) {
        Y2020M06D09_LC_P16_S1 instance = new Y2020M06D09_LC_P16_S1();
        // int[] arr = new int[]{-1, 2, 1, -4};
        int[] arr = new int[]{-1, 2, 1};
        System.out.println(instance.threeSumClosest(arr, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        // 3 <= nums.length <= 10^3
        // -10^3 <= nums[i] <= 10^3
        // -10^4 <= target <= 10^4
        // int result = 10000 + 3000 + 1;
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int difference = sum - target;
                if (difference == 0) {
                    return sum;
                } else if (difference > 0) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(difference) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
