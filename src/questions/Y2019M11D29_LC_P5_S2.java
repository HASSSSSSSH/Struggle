package questions;

public class Y2019M11D29_LC_P5_S2 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffgggggggggggggggggggg
        // abzdba
        // cbabxdaadz
        // ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
        Y2019M11D29_LC_P5_S2 instance = new Y2019M11D29_LC_P5_S2();
        System.out.println(instance.longestPalindrome("cbabxdaadz"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        boolean[][] map = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int i;
        int j;

        // wrong!!!
        // for (i = 0; i < s.length(); i++) {
        //     for (j = i; j < s.length(); j++) {
        //         if (i == j) {
        //             map[i][j] = true;
        //         } else if (i + 1 < s.length() && j - 1 >= 0
        //                 && map[i + 1][j - 1]
        //                 && s.charAt(i) == s.charAt(j)) {
        //             map[i][j] = true;
        //         } else {
        //             map[i][j] = false;
        //         }
        //     }
        // }

        for (i = 0; i < s.length(); i++) {
            for (j = 0; (j + i) < s.length(); j++) {
                int index = j + i;
                if (j == index) {
                    map[j][index] = true;
                } else if (j + 1 < s.length() && index - 1 >= 0
                        && map[j + 1][index - 1]
                        && s.charAt(j) == s.charAt(index)) {
                    map[j][index] = true;
                } else if (j + 1 > index - 1 && s.charAt(j) == s.charAt(index)) {
                    map[j][index] = true;
                } else {
                    map[j][index] = false;
                }

                if (map[j][index] && i > end - start) {
                    start = j;
                    end = index;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
