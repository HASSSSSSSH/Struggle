package questions;

public class TNN07Day19 {

    public static void main(String[] args) {
        TNN07Day19 t = new TNN07Day19();
        System.out.println(t.replaceSpace2(new StringBuffer("we are happy")));
    }

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0)
            return "";

        String s = str.toString();
        s = s.replace(" ", "%20");
        return s;
    }

    public String replaceSpace2(StringBuffer str) {
        if (str == null || str.length() == 0)
            return "";

        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (' ' == str.charAt(i))
                ++count;
        }
        if (count == 0)
            return str.toString();

        char[] chars = new char[str.length() + count * 2];
        char[] chs = str.toString().toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            chars[i] = chs[i];
        }
        int start = chs.length - 1;
        int end = chars.length - 1;
        while (start != end) {
            if (' ' == chars[start]) {
                chars[end] = '0';
                --end;
                chars[end] = '2';
                --end;
                chars[end] = '%';
            } else {
                chars[end] = chars[start];
            }
            --end;
            --start;
        }

        return String.copyValueOf(chars);
    }
}
