package questions;

public class Y2020M01D13_LC_P13_S2 {

    static int[] intArr = new int[(int) ('X') + 1];

    static {
        intArr[(int) ('I')] = 1;
        intArr[(int) ('V')] = 5;
        intArr[(int) ('X')] = 10;
        intArr[(int) ('L')] = 50;
        intArr[(int) ('C')] = 100;
        intArr[(int) ('D')] = 500;
        intArr[(int) ('M')] = 1000;
    }

    public static void main(String args[]) {
        Y2020M01D13_LC_P13_S2 instance = new Y2020M01D13_LC_P13_S2();
        System.out.println(instance.romanToInt("IXXDCVMICDLXMVIA"));
    }

    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        Character last = null;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int a = intArr[array[i]];
            if (a == 0) {
                continue;
            }
            if (last != null && lessThan(last, array[i])) {
                sum = sum + a - intArr[last] * 2;
            } else {
                sum += a;
            }
            last = array[i];
        }
        return sum;
    }

    public boolean lessThan(char c1, char c2) {
        return intArr[c1] < intArr[c2];
    }
}
