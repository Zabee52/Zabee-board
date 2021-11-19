package Programmers;

public class IsCanSqrtNaturalNumber {
    // 제곱근이 정수인지 판별하는 문제
    // 루트 씌운 값을 제곱했을때 원래값으로 돌아오는지 체크하면 된다.
    // https://programmers.co.kr/learn/courses/30/lessons/12934

    public long solution(long n) {
        long answer = 0;
        long sqrt = (long)Math.sqrt(n);

        if(Math.pow(sqrt, 2) == n){
            answer = (long)Math.pow(sqrt+1, 2);
        }else{
            answer = -1;
        }

        return answer;
    }
}
