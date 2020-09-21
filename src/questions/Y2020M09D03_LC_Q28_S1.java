package questions;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 实现 strStr() 函数
 * 给定一个 haystack 字符串和一个 needle 字符串, 在 haystack 字符串中找出 needle 字符串出现的第一个位置(从0开始)
 * 如果不存在, 则返回-1
 * <p>
 * Solution: Iterative
 * <p>
 * 时间复杂度: O(NL), 其中 N 为 haystack 字符串的长度, L 为 needle 字符串的长度
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M09D03_LC_Q28_S1 {

    public static void main(String args[]) {
        Y2020M09D03_LC_Q28_S1 instance = new Y2020M09D03_LC_Q28_S1();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            "28r32 jdfwfew[fd;f;2[1]d/.wokf29f2if23fuewjfh1hhdsjnjadad||!r1u3 ,e;f.;,f13o0`;l,effis".indexOf("fw");
            "1e8 u2398uedhscwdf]w[dds;171y3fhuidlcsdc';d;sb,l#$!jsansjnkfsv]askjd,sp2oe92rio220|*)1".indexOf("sb");
            "2sfs2asjaj93uhw ef2783y3rksd[[;ep23;.f.';[.sa,f[1][ed.cdsq|msm2.x,v/fkj298`jvh1u9nvljl".indexOf("lj");
            // System.out.println("".indexOf(""));
        }
        long temp = System.currentTimeMillis();
        System.out.println("indexOf() finished, cost: " + (temp - startTime));
        startTime = temp;

        for (int i = 0; i < 1000000; i++) {
            instance.strStr("2sfs2asjaj93uhw ef2783y3rksd[[;ep23;.f.';[.sa,f[1][ed.cdsq|msm2.x,v/fkj298`jvh1u9nvljl", "lj");
            instance.strStr("1e8 u2398uedhscwdf]w[dds;171y3fhuidlcsdc';d;sb,l#$!jsansjnkfsv]askjd,sp2oe92rio220|*)1", "sb");
            instance.strStr("28r32 jdfwfew[fd;f;2[1]d/.wokf29f2if23fuewjfh1hhdsjnjadad||!r1u3 ,e;f.;,f13o0`;l,effis", "fw");
            // System.out.println(instance.strStr("", ""));
        }
        System.out.println("strStr() finished, cost: " + (System.currentTimeMillis() - startTime));
    }

    public int strStr(String haystack, String needle) {
        int sourceCount = haystack.length();
        int targetCount = needle.length();
        if (targetCount == 0) {
            return 0;
        }
        if (sourceCount < targetCount) {
            return -1;
        }
        for (int start = 0; start < sourceCount; start++) {
            int i = 0;
            for (; i < targetCount; i++) {
                if (start + i >= sourceCount || haystack.charAt(start + i) != needle.charAt(i)) {
                    break;
                }
            }
            if (i == targetCount) {
                return start;
            }
        }
        return -1;
    }
}
