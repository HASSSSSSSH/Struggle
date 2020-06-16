package questions;

public class LongestCommonSubstringS2 {

    public static void main(String args[]) {
        LongestCommonSubstringS2 instance = new LongestCommonSubstringS2();
        int[] result = new int[3];
        System.out.println(instance.longestCommonSubstring("aa", "aab", result));
        System.out.println("result[0]: " + result[0] + " result[1]: " + result[1] + " result[2]: " + result[2]);
    }

    public String longestCommonSubstring(String str1, String str2, int[] result) {
        int start1 = -1;
        int start2 = -1;
        int length = 0;
        int comparision = 0;
        int[][] array = new int[str1.length()][str2.length()];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    array[i][j] = i - 1 >= 0 && j - 1 >= 0 ? (array[i - 1][j - 1] + 1) : 1;
                } else {
                    array[i][j] = 0;
                }
                if (array[i][j] > length) {
                    length = array[i][j];
                    start1 = i + 1 - length;
                    start2 = j + 1 - length;
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
