package questions;

public class Y2019M10D30_LC_P7_S1 {

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    public static void main(String args[]) {
        // Integer.MIN_VALUE = -2147483648
        // Integer.MAX_VALUE = 2147483647
        Y2019M10D30_LC_P7_S1 instance = new Y2019M10D30_LC_P7_S1();
        System.out.println(instance.reverse(-2147483647));
    }

    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        boolean negative = x < 0;
        char[] chars = int2chars(x);

        int y = 0;
        if (!isOverflow(negative, chars)) {
            for (int i = 0; i < chars.length; i++) {
                y += ((chars[i]) - '0') * Math.pow(10, chars.length - i - 1);
            }
        }
        if (negative) {
            y *= -1;
        }
        return y;
    }

    // Will fail if i == Integer.MIN_VALUE
    public char[] int2chars(int x) {
        x = x < 0 ? -x : x;
        int size = x < 0 ? stringSize(-x) : stringSize(x);
        char[] chars = new char[size];
        int index = 0;
        do {
            // 当 x = Integer.MIN_VALUE = -2147483648, cause ArrayIndexOutOfBoundsException
            chars[index] = (char) ((x % 10) + '0');
            index++;
            x /= 10;
        } while (x != 0);
        return chars;
    }

    public int stringSize(int x) {
        for (int i = 0; ; i++) {
            if (x <= sizeTable[i]) {
                return i + 1;
            }
        }
    }

    public boolean isOverflow(boolean negative, char[] chars) {
        if (chars.length > 10) {
            return true;
        }
        if (chars.length <= 9) {
            return false;
        }
        char[] maxValueChars = int2chars(Integer.MAX_VALUE);
        for (int i = 0; i < maxValueChars.length - 1; i++) {
            if (maxValueChars[maxValueChars.length - i - 1] > chars[i]) {
                return false;
            } else if (maxValueChars[maxValueChars.length - i - 1] < chars[i]) {
                return true;
            }
        }

        if (negative) {
            return maxValueChars[0] < chars[chars.length - 1];
        } else {
            return maxValueChars[0] - 1 < chars[chars.length - 1];
        }
    }
}
