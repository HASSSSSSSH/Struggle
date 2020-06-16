package questions;

public class TNN08Day03P10 {

    public static void main(String[] args) {
        TNN08Day03P10 t = new TNN08Day03P10();
        System.out.println(t.Fibonacci(4));
    }

    public int Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;

        int temp;
        int preValue = 0;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            temp = result;
            result = result + preValue;
            preValue = temp;
        }

        return result;
    }
}
