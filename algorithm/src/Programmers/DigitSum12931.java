package Programmers;

public class DigitSum12931 {
    /*
        입력받은 숫자의 자릿수마다 더해서 출력해주면 된다.
        1. Call by Value 방식은 원본값을 수정하지 않기 때문에 /= 10 처리하면 되는 것
        2. 10으로 나머지 연산을 수행한 결과가 일의자리수인 것
        을 알면 쉽게 풀 수 있다.
        https://programmers.co.kr/learn/courses/30/lessons/12931
     */
    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}
