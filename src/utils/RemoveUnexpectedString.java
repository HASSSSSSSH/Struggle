package utils;

import java.util.Scanner;

public class RemoveUnexpectedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String input = "";
        while (!"shutdown".equals(input)) {
            input = scanner.nextLine();
            stringBuilder.append(input);
        }
        System.out.println("");
        System.out.println(removeUnexpectedString(stringBuilder.toString(), "* ", ""));
    }

    public static String removeUnexpectedString(String s, CharSequence target, CharSequence replacement) {
        if (s == null) {
            return "";
        }

        return s.replace(target, replacement);
    }
}
