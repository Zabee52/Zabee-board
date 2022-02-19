package Programmers;

import java.util.Locale;

public class ModeCharacter {
    public static String solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 97]++;
        }

        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                result.append((char) (i + 97));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aAb"));
    }
}
