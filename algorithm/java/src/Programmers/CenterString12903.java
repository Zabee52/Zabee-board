package Programmers;

public class CenterString12903 {
    /*
        가운데 문자만 뽑아내면 되는 문제다.
        문자수가 짝수일 경우 두 글자를 가져오면 된다.
        https://programmers.co.kr/learn/courses/30/lessons/12903
     */
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2+1);
        } else {
            answer = String.valueOf(s.charAt(s.length() / 2));
        }

        return answer;
    }
}
