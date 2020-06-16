package questions;

public class Y2019M11D18_LC_P9_S1 {

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    public static void main(String args[]) {
        Y2019M11D18_LC_P9_S1 instance = new Y2019M11D18_LC_P9_S1();
        System.out.println(instance.isPalindrome(0));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int size = stringSize(x);
        int[] array = new int[size];
        int i = 0;
        do {
            int pop = x % 10;
            array[i] = pop;
            x /= 10;
            i++;
        } while (x != 0);
        for (i = 0; i < size / 2; i++) {
            if (array[i] != array[size - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int stringSize(int x) {
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }
}
