package questions;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * 实现 strStr() 函数
 * 给定一个 haystack 字符串和一个 needle 字符串, 在 haystack 字符串中找出 needle 字符串出现的第一个位置(从0开始)
 * 如果不存在, 则返回-1
 * <p>
 * Solution: Iterative
 * Reference: https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode/
 * <p>
 * 时间复杂度: O((N − L) L), 其中 N 为 haystack 字符串的长度, L 为 needle 字符串的长度
 * 内循环中比较字符串的复杂度为 L, 总共需要比较 (N - L) 次
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M09D07_LC_Q28_S3 {

    public static void main(String args[]) {
        Y2020M09D07_LC_Q28_S3 instance = new Y2020M09D07_LC_Q28_S3();
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
        int n = haystack.length();
        int L = needle.length();
        int max = n - L;
        for (int start = 0; start <= max; start++) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
