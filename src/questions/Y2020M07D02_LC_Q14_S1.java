package questions;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Y2020M07D02_LC_Q14_S1 {

    public static void main(String args[]) {
        Y2020M07D02_LC_Q14_S1 instance = new Y2020M07D02_LC_Q14_S1();
        // new String[]{"flower", "flow", "flight"}
        // new String[]{"lower", "flow", "cat"}
        System.out.println(instance.longestCommonPrefix(new String[]{"lower", "flow", "cat"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        int p = 0;
        outer:
        while (true) {
            if (p >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(p);
            for (String str : strs) {
                if (p >= str.length() || str.charAt(p) != c) {
                    break outer;
                }
            }
            p++;
        }
        return p > 0 ? strs[0].substring(0, p) : "";
    }
}
