package questions;

public class Y2019M10D30_LC_P7_S2 {

    public static void main(String args[]) {
        // Integer.MIN_VALUE = -2147483648
        // Integer.MAX_VALUE = 2147483647
        Y2019M10D30_LC_P7_S2 instance = new Y2019M10D30_LC_P7_S2();
        System.out.println(instance.reverse(0));
    }

    public int reverse(int x) {
        // if (x == 0 || x == Integer.MIN_VALUE) {
        //     return 0;
        // }

        int oneTenthMax = Integer.MAX_VALUE / 10;
        int oneTenthMin = Integer.MIN_VALUE / 10;
        int y = 0;
        do {
            int pop = x % 10;

            // 不通用的
            // if (y > oneTenthMax || y < oneTenthMin
            //         || (y == oneTenthMax && pop > 7)
            //         || (y == oneTenthMin && pop < -8)) {
            //         wrong: || (y == oneTenthMin && pop > 8)) {
            //     return 0;
            // }

            if (y > oneTenthMax || y < oneTenthMin
                    || (y == oneTenthMax && pop > Integer.MAX_VALUE % 10)
                    || (y == oneTenthMin && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            y = y * 10 + pop;
            x /= 10;
        } while (x != 0);
        return y;
    }
}
