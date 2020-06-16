package questions;

public class LongestCommonSubstring {

    public static void main(String args[]) {
        LongestCommonSubstring instance = new LongestCommonSubstring();
        System.out.println(instance.findLongest("", "".length(), "aab", "aab".length()));
    }

    public int findLongest(String A, int n, String B, int m) {
        int length = 0;
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    array[i][j] = i - 1 >= 0 && j - 1 >= 0 ? (array[i - 1][j - 1] + 1) : 1;
                } else {
                    array[i][j] = 0;
                }
                if (array[i][j] > length) {
                    length = array[i][j];
                }
            }
        }
        return length;
    }
}
