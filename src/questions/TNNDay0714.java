package questions;

public class TNNDay0714 {

    public static void main(String[] args) {
        TNNDay0714 t = new TNNDay0714();
        int numbers[] = new int[]{1, 2, 2, 3, 3, 3, 3, 3, 4, 5};
        System.out.println(t.GetNumberOfK(numbers, 3));
    }

    public int GetNumberOfK(int[] array, int k) {
        int index = binarySearch(array, 0, array.length - 1, k);
        if (index != -1) {
            return findTheLastK(array, k, index, array.length - 1)
                    - findTheFirstK(array, k, 0, index) + 1;
        }
        return 0;
    }

    public int binarySearch(int[] arr, int start, int end, int key) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (arr[mid] > key)
            return binarySearch(arr, start, mid - 1, key);
        if (arr[mid] < key)
            return binarySearch(arr, mid + 1, end, key);
        return mid;
    }

    public int findTheFirstK(int[] array, int k, int start, int end) {
        if (start >= end)
            return end;
        int mid = start + ((end - start) >> 1);
        if (k == array[mid]) {
            if (mid - 1 >= start && k == array[mid - 1])
                return findTheFirstK(array, k, start, mid - 1);
            else {
                return mid;
            }
        } else if (k > array[mid]) {
            return findTheFirstK(array, k, mid + 1, end);
        }
//        if (k < array[mid]) {
//            return findTheFirstK(array, k, mid + 1, end);
//        }
        return end;
    }

    public int findTheLastK(int[] array, int k, int start, int end) {
        if (start >= end)
            return end;
        int mid = start + ((end - start) >> 1);
        if (k == array[mid]) {
            if (mid + 1 <= end && k == array[mid + 1])
                return findTheLastK(array, k, mid + 1, end);
            else {
                return mid;
            }
        } else if (k < array[mid]) {
            return findTheLastK(array, k, start, mid - 1);
        }
//        if (k < array[mid]) {
//            return findTheFirstK(array, k, mid + 1, end);
//        }
        return end;
    }
}
