package test;

public class ReturnOrFinally {
    public int test() {
        int x = 1;

        try {
            return ++x;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ++x;
            // return ++x;
        }
        return x;
    }

    public static void main(String[] args) {
        ReturnOrFinally t = new ReturnOrFinally();
        System.out.println(t.test());
    }
}
