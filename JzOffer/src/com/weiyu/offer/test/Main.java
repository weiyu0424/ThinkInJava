package com.weiyu.offer.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String reg = scanner.nextLine();
            String str = scanner.nextLine();

            System.out.println(matcher(reg, str));
        }

        scanner.close();
    }

    private static boolean matcher(String reg, String str) {
        return matcher(reg, 0, str, 0);
    }

    private static boolean matcher(String reg, int i, String str, int j) {
        if (i >= reg.length()) {
            return j >= str.length();
        }

        if (j >= str.length()) {
            return i >= str.length();
        }

        boolean result = false;
        switch (reg.charAt(i)) {
            case '*':
                result = matcher(reg, i, str, j + 1);
                if (result) {
                    return true;
                }
                result = matcher(reg, i + 1, str, j);
                if (result) {
                    return true;
                }
                result = matcher(reg, i + 1, str, j + 1);
                break;
            case '?':
                result = matcher(reg, i + 1, str, j + 1);
                break;
            default:
                if (reg.charAt(i) == str.charAt(j)) {
                    result = matcher(reg, i + 1, str, j + 1);
                }
        }
        return result;
    }
}