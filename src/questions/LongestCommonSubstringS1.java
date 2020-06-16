package questions;

public class LongestCommonSubstringS1 {

    public static void main(String args[]) {
        LongestCommonSubstringS1 instance = new LongestCommonSubstringS1();
        int[] result = new int[3];
        System.out.println(instance.longestCommonSubstring("ab", "aab", result));
        System.out.println("result[0]: " + result[0] + " result[1]: " + result[1] + " result[2]: " + result[2]);
    }

    public String longestCommonSubstring(String str1, String str2, int[] result) {
        int start1 = -1;
        int start2 = -1;
        int length = 0;
        int comparision = 0;
        int k;
        int l;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                k = i;
                l = j;
                while (k < str1.length() && l < str2.length()) {
                    comparision++;
                    if (str1.charAt(k) != str2.charAt(l)) {
                        break;
                    }
                    k++;
                    l++;
                }
                if (length < k - i) {
                    length = k - i;
                    start1 = i;
                    start2 = j;
                }
            }
        }
        System.out.println("comparision: " + comparision);
        if (length > 0) {
            result[0] = length;
            result[1] = start1;
            result[2] = start2;
            return str1.substring(start1, start1 + length);
        }
        return "";
    }
}
