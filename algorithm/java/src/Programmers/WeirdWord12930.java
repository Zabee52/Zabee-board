package Programmers;

public class WeirdWord12930 {
    // 이 문제와 관련된 내용은 회고록에서 이상한문자열 찾기 관련에 적어놨음. 실수할 수 있는 부분!
    // https://programmers.co.kr/learn/courses/30/lessons/12930
    // 문제가 발생함 : https://dazbee.tistory.com/10?category=1034426
    // 문제가 뭔지 알아냄 : https://dazbee.tistory.com/26?category=1034426

    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int cnt = 0;

        for (String ss : str) {
            if (ss.contains(" ")) {
                cnt = 0;
            } else {
                cnt++;
            }

            if (cnt % 2 == 1) {
                answer += ss.toUpperCase();
            } else {
                answer += ss.toLowerCase();
            }
        }

        return answer;
    }
}