package Programmers;

public class WhereIsKim12919 {
    /*
        배열에 있는 kim을 찾는 문제다.
        String 클래스 비교 메소드 .equals()를 사용할 줄 아는가 물어보는 문제이다.
        만약 이걸 못 풀겠다면 문법 공부부터 하자.
        https://programmers.co.kr/learn/courses/30/lessons/12919
     */

    public String solution(String[] seoul) {
        String answer = "";
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }
}
