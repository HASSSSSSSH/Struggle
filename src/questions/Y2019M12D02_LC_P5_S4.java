package questions;

public class Y2019M12D02_LC_P5_S4 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffggggggggggggggggggggg
        // abzdba
        // cccbbccd
        // cbabxdaad
        // cbabxdaadz
        // abcdxddcba
        Y2019M12D02_LC_P5_S4 instance = new Y2019M12D02_LC_P5_S4();
        System.out.println(instance.longestPalindrome("abcdbc"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        String reverse = new StringBuilder(s).reverse().toString();
        int maxLen = 0;

        // using two-dimensional array
        // int[][] arr = new int[s.length()][s.length()];
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         if (s.charAt(i) == reverse.charAt(j)) {
        //             arr[i][j] = i >= 1 && j >= 1 ? arr[i - 1][j - 1] + 1 : 1;
        //         } else {
        //             arr[i][j] = 0;
        //         }
        //         // think about it!
        //         if (arr[i][j] > maxLen && s.length() - 1 - j == i + 1 - arr[i][j]) {
        //             maxLen = arr[i][j];
        //             end = i;
        //             start = i - maxLen + 1;
        //         }
        //     }
        // }

        // just using one-dimensional array
        int[] arr = new int[s.length()];
         for (int i = 0; i < s.length(); i++) {
             for (int j = s.length() - 1; j >= 0; j--) {
                 if (s.charAt(i) == reverse.charAt(j)) {
                     arr[j] = j >= 1 ? arr[j - 1] + 1 : 1;
                 } else {
                     arr[j] = 0;
                 }
                 // think about it!
                 if (arr[j] > maxLen && s.length() - 1 - j == i + 1 - arr[j]) {
                     maxLen = arr[j];
                     end = i;
                     start = i - maxLen + 1;
                 }
             }
         }

        return s.substring(start, end + 1);
    }
}
