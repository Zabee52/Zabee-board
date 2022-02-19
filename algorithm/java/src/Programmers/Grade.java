package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Grade {
    public static int[] solution(int[] grade) {
        List<Integer> scoreList = new ArrayList<>();
        for (int i : grade) {
            scoreList.add(i);
        }
        scoreList.sort(Collections.reverseOrder());

        int[] rank = new int[grade.length];
        for (int i = 0; i < grade.length; i++) {
            for (int k = 0; k < scoreList.size(); k++) {
                if (grade[i] == scoreList.get(k)) {
                    rank[i] = k + 1;
                    break;
                }
            }
        }

        return rank;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }
}

