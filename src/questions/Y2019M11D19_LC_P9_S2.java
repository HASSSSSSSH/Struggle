package questions;

public class Y2019M11D19_LC_P9_S2 {

    public static void main(String args[]) {
        Y2019M11D19_LC_P9_S2 instance = new Y2019M11D19_LC_P9_S2();
        System.out.println(instance.isPalindrome(1112111));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }
}
