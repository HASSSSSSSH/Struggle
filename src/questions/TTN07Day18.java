package questions;

public class TTN07Day18 {

    public int NumberOf1(int n) {
        int count = 0;
        int a = 1;
        while (a != 0) {
            if ((n & a) > 0) {
                ++count;
            }
            a = a << 1;
        }
        if (n < 0)
            ++count;

        return count;
    }
}
