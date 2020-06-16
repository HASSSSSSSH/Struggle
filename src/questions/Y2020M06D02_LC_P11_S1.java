package questions;

public class Y2020M06D02_LC_P11_S1 {

    public static void main(String args[]) {
        Y2020M06D02_LC_P11_S1 instance = new Y2020M06D02_LC_P11_S1();
        System.out.println(instance.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int min = min(height[i], height[j]);
                int area = min * (j - i);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
