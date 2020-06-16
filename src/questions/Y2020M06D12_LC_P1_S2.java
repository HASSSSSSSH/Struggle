package questions;

import java.util.HashMap;

public class Y2020M06D12_LC_P1_S2 {

    public static void main(String args[]) {
        Y2020M06D12_LC_P1_S2 instance = new Y2020M06D12_LC_P1_S2();
        // int[] nums = new int[]{3, 2, 4};
        int[] nums = new int[]{3, 9, 2, 4};
        int[] r = instance.twoSum(nums, 11);
        System.out.println(r[0] + "  " + r[1]);
        System.out.println(nums[r[0]] + "  " + nums[r[1]]);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                result[0] = map.get(another);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
