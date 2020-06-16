package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Y2020M06D16_LC_P15_S2 {

    public static void main(String args[]) {
        Y2020M06D16_LC_P15_S2 instance = new Y2020M06D16_LC_P15_S2();
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2};
        System.out.println(instance.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int preValue = nums[0] + 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (preValue == nums[i]) {
                continue;
            }
            preValue = nums[i];

            // int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    list.add(l);

                    do {
                        left++;
                    } while (left < right && nums[left - 1] == nums[left]);
                    do {
                        right--;
                    } while (left < right && nums[right + 1] == nums[right]);
                } else if (sum > 0) {
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
        return list;
    }
}
