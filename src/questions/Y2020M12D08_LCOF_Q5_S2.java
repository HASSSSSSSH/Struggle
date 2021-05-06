package questions;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 替换空格
 * <p>
 * 请实现一个函数, 把字符串 s 中的每个空格替换成 "%20"
 * <p>
 * 示例 1:
 * 输入: s = "We are happy."
 * 输出: "We%20are%20happy."
 * <p>
 * Tags: {@link questions.tags.String}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 * <p>
 * Optimization of {@link Y2020M12D08_LCOF_Q5_S1}: More Readable
 */
public class Y2020M12D08_LCOF_Q5_S2 {

    public static void main(String args[]) {
        Y2020M12D08_LCOF_Q5_S2 instance = new Y2020M12D08_LCOF_Q5_S2();

        // "We are happy."
        // " happy "

        System.out.println(instance.replaceSpace(" happy "));
    }

    public String replaceSpace(String s) {
        int length = s.length();

        // 当 s 中的每一个字符都是 ' ' 时, 新的字符串最大长度为 length * 3
        char[] array = new char[length * 3];

        // 总是指向新字符数组最后一个字符的 后一个位置
        // 表示一个新的非空格字符在新字符数组中的下标
        int size = 0;

        // 从前往后遍历
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }

        // 返回字符数组 array 在区间 [0, size - 1] 组成的字符串
        return new String(array, 0, size);
    }
}
