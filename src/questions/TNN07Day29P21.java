package questions;

public class TNN07Day29P21 {

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return;

        int start = 0;
        int end = array.length - 1;
        int temp;

        while (start < end) {
            while (start < end && (array[start] & 0x1) != 0) {
                ++start;
            }
            while (start < end && (array[end] & 0x1) == 0) {
                --end;
            }

            if (start < end) {
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }
}
