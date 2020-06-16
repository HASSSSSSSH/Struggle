package bitwiseOperation;

public class Main {

    public static void main(String[] args) {
//        int a = 4 >> 1;
//        int b = 5 >> 1;
//        int c = -4 >> 1;
//        int d = -5 >> 1;
//        int e = -5 >> 1 + 1;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(4 >> 1 + 1);
//        System.out.println((4 >> 1) + 1);
//
//        for (int i = -10; i <= 10; i++) {
//            System.out.println("result = " + (i << 1)
//                    + ((i << 1) == (i * 2) ? "" : (" false " + (i << 1) + " != " + (i * 2))));
//        }
//        for (int i = -10; i <= 10; i++) {
//            System.out.println("result = " + (i >> 1)
//                    + ((i >> 1) == (i / 2) ? "" : (" false " + (i >> 1) + " != " + (i / 2))));
//        }

        for (int n = 1; n < 10; n++) {
            for (int i = -299; i < -100; i += 2) {
//            System.out.println("result = " + (i >> 3)
//                    + ((i >> 3) == (i / 8) ? "" : (" false " + (i >> 3) + " != " + (i / 8))));

                System.out.println("result = " + ((i >> n) + 1)
                        + (((i >> n) + 1) == (int) (i / Math.pow(2, n))
                        ? "" : (" false " + ((i >> n) + 1) + " != " + (int) (i / Math.pow(2, n)))));
            }
        }
    }
}