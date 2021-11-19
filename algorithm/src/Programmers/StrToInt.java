package Programmers;

public class StrToInt {
    // 숩다 수워
    // https://programmers.co.kr/learn/courses/30/lessons/12925

    public int solution(String s) {
        int answer = Integer.parseInt(s);

        return answer;
    }

    public int solution2(String s) {
        int answer = 0;
        // 곱해줄 자릿수
        int digits = 1;

        // 일의자리부터 연산 시작
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);

            // 맨 앞글자가 부호면 탈출
            if(c == '-' || c == '+'){
                break;
            }

            // char은 아스키코드표에 기반하여 값을 보관하기 때문에
            // 정수로 치환할 때는 그 값만큼 빼줘야함.
            // 숫자 0이 아스키코드표 기준 48인가 그런데 그냥 '0'으로 빼버려도 됨.
            answer += (c - '0') * digits;

            // 자릿수 up
            digits *= 10;
        }

        // 마이너스 부호일 경우 부호 전환
        if(s.charAt(0) == '-'){
            answer *= -1;
        }

        return answer;
    }
}