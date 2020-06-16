package questions;

public class TTN07Day16 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0)
            return 0;
        int midIndex = (array.length - 1) >> 1;
        int targetNum = array[midIndex];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == targetNum) {
                ++count;
            }
        }
        return (count << 1) > array.length ? targetNum : 0;
    }

    public int MoreThanHalfNum_Solution_B(int[] array) {
//        if (array.length == 0)
//            return 0;
//        int a = 0;
//        int b = array.length - 1;
//        while (a < b) {
//            if ((array[a] + array[b]) == )
//        }
        return 0;
    }
}
