package questions;

public class Y2019M12D02_LC_P5_S3 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffgggggggggggggggggggg
        // abzdba
        // cccbbccd
        // cbabxdaad
        // cbabxdaadz
        // abcdxddcba
        Y2019M12D02_LC_P5_S3 instance = new Y2019M12D02_LC_P5_S3();
        System.out.println(instance.longestPalindrome("abcdxddcba"));
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
        for (int i = 0; i < s.length(); i++) {
            // can be simplified
            // int length = expandAroundCenter(s, i, i);
            // if (length > end - start + 1) {
            //     start = i - (length - 1) / 2;
            //     end = i + (length - 1) / 2;
            // }
            // length = expandAroundCenter(s, i, i + 1);
            // if (length > end - start + 1) {
            //     start = i - (length - 2) / 2;
            //     end = i + 1 + (length - 2) / 2;
            // }

            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int length = (len1 >= len2) ? len1 : len2;
            if (length > end - start + 1) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }

        // Actually, this is redundant
        // Now, no need to check (right >= s.length())
        // int length = expandAroundCenter(s, s.length() - 1, s.length() - 1);
        // if (length > end - start + 1) {
        //     start = s.length() - 1 - (length - 1) / 2;
        //     end = s.length() - 1 + (length - 1) / 2;
        // }

        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        // if (right >= s.length()) {
        //     return 0;
        // }

        // can be simplified
        // while (left >= 0 && right < s.length()) {
        //     if (s.charAt(left) != s.charAt(right)) {
        //         break;
        //     }
        //     --left;
        //     ++right;
        // }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }

        // (right - 1) - (left + 1) + 1
        return right - left - 1;
    }
}
