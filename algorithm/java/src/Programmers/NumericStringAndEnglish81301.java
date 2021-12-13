package Programmers;

public class NumericStringAndEnglish81301 {
    /*
        String의 내장함수 replaceAll을 모른다면 진짜 한참동안 헤멜 수도 있는 문제다.
        대응되는 String을 만들어 replaceAll 하면 되는 것을 기억하자.
        https://programmers.co.kr/learn/courses/30/lessons/81301
     */

    public int solution(String s) {
        int answer = 0;
        String[] numStr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] danStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i++){
            s = s.replaceAll(danStr[i], numStr[i]);
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}
