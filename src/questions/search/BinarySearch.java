package questions.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 5, 6, 7, 8, 9, 11};

        System.out.println(binarySearch(array, 0, array.length, 11));
    }

    /**
     * Same as {@link java.util.Arrays#binarySearch0(int[], int, int, int)}
     */
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            // same as (low + ((high - low) >> 1))
            // >>>(无符号右移): 无论符号位是 0 或者 1, 将该数的二进制值整体(包括符号位)右移, 右边部分舍弃, 左边部分总是以 0 填充
            // 即使 (low + high) 溢出, 也能够得出正确答案
            int mid = (low + high) >>> 1;

            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
