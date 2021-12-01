package com.dong.basic;

public class RevertString {
    public String revertString(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        int len = str.length();
        char c;
        for (int i = 0; i < len / 2; i++) {
            c = chars[i];
            chars[i] = chars[len - 1 - i];
            chars[len - 1 - i] = c;
        }
        return new String(chars);
    }
}
