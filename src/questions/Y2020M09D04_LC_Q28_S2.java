package questions;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 实现 strStr() 函数
 * 给定一个 haystack 字符串和一个 needle 字符串, 在 haystack 字符串中找出 needle 字符串出现的第一个位置(从0开始)
 * 如果不存在, 则返回-1
 * <p>
 * Solution: Iterative
 * <p>
 * 时间复杂度: 最坏情况下的时间复杂度为 O((N − L) L)
 * 最优情况下的时间复杂度为 O(N), 此时 haystack 字符串中任意一个字符都不与 needle 字符串的第一个字符相等, 或者 haystack 字符串中只有一个字符与 needle 字符串的第一个字符相等
 * 其中 N 为 haystack 字符串的长度, L 为 needle 字符串的长度
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M09D04_LC_Q28_S2 {

    public static void main(String args[]) {
        Y2020M09D04_LC_Q28_S2 instance = new Y2020M09D04_LC_Q28_S2();
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
        int max = sourceCount - targetCount;
        char first = needle.charAt(0);
        for (int start = 0; start <= max; start++) {
            if (first != haystack.charAt(start)) {
                while (++start <= max && haystack.charAt(start) != first) ;
            }
            if (start <= max) {
                int i = 1;
                for (; i < targetCount && haystack.charAt(start + i) == needle.charAt(i); i++) ;
                if (i == targetCount) {
                    return start;
                }
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int sourceCount = haystack.length();
        int targetCount = needle.length();
        if (0 >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = (sourceCount - targetCount);

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
}
