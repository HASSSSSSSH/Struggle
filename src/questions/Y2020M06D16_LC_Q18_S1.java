package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Y2020M06D16_LC_Q18_S1 {

    public static void main(String args[]) {
        Y2020M06D16_LC_Q18_S1 instance = new Y2020M06D16_LC_Q18_S1();
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2};
        System.out.println(instance.fourSum(arr, 2));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int left, right, sum;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = nums.length - 1;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        res.add(l);

                        do {
                            left++;
                        } while (left < right && nums[left - 1] == nums[left]);
                        do {
                            right--;
                        } while (left < right && nums[right + 1] == nums[right]);
                    } else if (sum > target) {
                        do {
                            right--;
                        } while (left < right && nums[right + 1] == nums[right]);
                    } else {
                        do {
                            left++;
                        } while (left < right && nums[left - 1] == nums[left]);
                    }
                }
            }
        }
        return res;
    }
}
