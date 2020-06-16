package questions;

public class Y2019M11D28_LC_P5_S1 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffgggggggggggggggggggg
        // abzdba
        Y2019M11D28_LC_P5_S1 instance = new Y2019M11D28_LC_P5_S1();
        System.out.println(instance.longestPalindrome("abzdba"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int i;
        int j;
        String longest = "";
        for (i = 0; i < s.length(); i++) {
            for (j = i; j <= s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) > longest.length()) {
                    longest = subStr;
                }
            }
        }
        return longest;
    }

    public int isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return 0;
            }
        }
        return s.length();
    }
}
