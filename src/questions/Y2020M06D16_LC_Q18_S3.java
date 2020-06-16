package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Y2020M06D16_LC_Q18_S3 {

    public static void main(String args[]) {
        Y2020M06D16_LC_Q18_S3 instance = new Y2020M06D16_LC_Q18_S3();
        // int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] arr = new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2};
        System.out.println(instance.fourSum(arr, 2));
    }

    /**
     * 在一个已排序数组中, 判断某几个数之和是否满足某一数值
     * 如果数组的前几个元素之和, 即最小值, 仍大于此数值, 则不可能满足条件
     * 如果数组的后几个元素之和, 即最大值, 仍小于此数值, 则不可能满足条件
     */
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
            // min > target, just break
            if ((nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) > target) {
                break;
            }
            // max < target, continue
            if ((nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3]) < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                // min > target, just break
                if ((nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) > target) {
                    break;
                }
                // max < target, continue
                if ((nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2]) < target) {
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
