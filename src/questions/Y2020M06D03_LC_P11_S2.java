package questions;

public class Y2020M06D03_LC_P11_S2 {

    public static void main(String args[]) {
        Y2020M06D03_LC_P11_S2 instance = new Y2020M06D03_LC_P11_S2();
        System.out.println(instance.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            int area = min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            // 移动短板, 丢弃的那些以此短板计算得到的面积, 只能是小于当前面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
