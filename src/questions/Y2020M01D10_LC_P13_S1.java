package questions;

import java.util.HashMap;

public class Y2020M01D10_LC_P13_S1 {

    int[] intArr = new int[(int) ('X')];

    HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
        boolean init = false;

        @Override
        public Integer get(Object key) {
            if (!init) {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
                init = true;
            }
            return super.get(key);
        }
    };

    public static void main(String args[]) {
        Y2020M01D10_LC_P13_S1 instance = new Y2020M01D10_LC_P13_S1();
        System.out.println(instance.romanToInt("II"));
    }

    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        Character last = null;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            Integer a = map.get(array[i]);
            if (a == null) {
                continue;
            }
            if (last != null && lessThan(last, array[i])) {
                sum = sum + a - map.get(last) * 2;
            } else {
                sum += a;
            }

            last = array[i];
        }
        return sum;
    }

    public boolean lessThan(char c1, char c2) {
        return map.get(c1) < map.get(c2);
    }
}
