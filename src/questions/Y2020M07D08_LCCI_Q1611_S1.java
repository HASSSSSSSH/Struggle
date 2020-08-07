package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diving-board-lcci/
 * 你正在使用一堆木板建造跳水板。
 * 有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。
 * 编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 */
public class Y2020M07D08_LCCI_Q1611_S1 {

    public static void main(String args[]) {
        Y2020M07D08_LCCI_Q1611_S1 instance = new Y2020M07D08_LCCI_Q1611_S1();
        // 1, 2, 0
        // 1, 2, 3
        // 1, 1, 10000
        System.out.println(Arrays.toString(instance.divingBoard(1, 2, 3)));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        int diff = longer - shorter;
        if (diff == 0) {
            return new int[]{k * shorter};
        }
        int[] res = new int[k + 1];
        res[0] = k * shorter;
        int n = k - 1;
        while (n >= 0) {
            res[k - n] = res[k - n - 1] + diff;
            n--;
        }
        return res;
    }
}
