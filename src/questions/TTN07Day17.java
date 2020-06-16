package questions;

import java.util.ArrayList;

public class TTN07Day17 {

    public static void main(String[] args) {
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array.length == 0 || array.length == 1)
            return new ArrayList<>();
        int a = 0;
        int b = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (a < b) {
            if ((array[a] + array[b]) == sum) {
                list.add(array[a]);
                list.add(array[b]);
                break;
            } else if ((array[a] + array[b]) > sum) {
                b--;
            } else if ((array[a] + array[b]) < sum) {
                a++;
            }
        }
        return list;
    }
}
