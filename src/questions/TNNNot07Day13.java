package questions;

public class TNNNot07Day13 {

    public static int binarySearch(int[] arr, int start, int end, int key) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (arr[mid] > key)
            return binarySearch(arr, start, mid - 1, key);
        if (arr[mid] < key)
            return binarySearch(arr, mid + 1, end, key);
        return mid;
    }
}
