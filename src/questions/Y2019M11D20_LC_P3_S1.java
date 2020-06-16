package questions;

import java.util.HashMap;

public class Y2019M11D20_LC_P3_S1 {

    public static void main(String args[]) {
        // ""
        // "abba"
        // "dvdf"
        // "dvdff"
        // "666666"
        Y2019M11D20_LC_P3_S1 instance = new Y2019M11D20_LC_P3_S1();
        System.out.println(instance.lengthOfLongestSubstring("dvdff"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int rev = 0;
        HashMap<String, Integer> map = new HashMap<>(s.length());
        int i = 0;
        int start = 0;
        for (; i < s.length(); i++) {
            Integer old;
            if ((old = map.put(String.valueOf(s.charAt(i)), i)) != null) {
                rev = i - start > rev ? i - start : rev;
                start = old + 1 > start ? old + 1 : start;
            }
        }
        rev = i - start > rev ? i - start : rev;
        return rev;
    }
}
