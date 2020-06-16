package questions;

import java.util.HashMap;

public class TNN08Day15LCP1 {

    // {3, 2, 4, 3}  {3, 2, 4}
    public static void main(String[] args) {
        TNN08Day15LCP1 t = new TNN08Day15LCP1();
        int[] nums = new int[]{3, 2, 4};
        int[] r = t.twoSum(nums, 6);
        System.out.println(r[0] + "  " + r[1]);
        System.out.println(nums[r[0]] + "  " + nums[r[1]]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                if (2 * nums[i] == target) {
                    result[0] = hashMap.get(nums[i]);
                    result[1] = i;
                    return result;
                } else {
                    continue;
                }
            }
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (2 * nums[i] != target && hashMap.get(target - nums[i]) != null) {
                result[0] = i < hashMap.get(target - nums[i]) ? i : hashMap.get(target - nums[i]);
                result[1] = i < hashMap.get(target - nums[i]) ? hashMap.get(target - nums[i]) : i;
                break;
            }
        }
        return result;
    }
}
