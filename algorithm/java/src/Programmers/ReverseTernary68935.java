package Programmers;

public class ReverseTernary68935 {
    // 삼진수로 바꾸고 앞뒤 뒤집어서 다시 십진수로 변환하기
    // parse 시리즈의 진수변환 기능을 모른다면 아래와 같은 과정을 거쳐야 한다.
    // https://programmers.co.kr/learn/courses/30/lessons/68935

    public int solution(int n) {
        int answer = 0;
        String str = "";
        int digit = 3;

        // 3으로 나눈 나머지 = 첫번째 자리
        // 값을 3으로 나눔
        // 3으로 나눈 나머지 = 두 번째 자리
        // 값을 3으로 나눔
        // 3으로 나눈 나머지 = n 번째 자리
        // 값을 3으로 나눔
        // ...
        // 0이면 종료
        while (n != 0) {
            str += String.valueOf(n % digit);
            n /= digit;
        }
        str = str.substring(0, str.length());

        // answer = Integer.parseInt(str, 3); 하면 끝남
        long num = Long.parseLong(str);

        for (int i = 1; num != 0; i *= digit) {
            answer += num % 10 * i;
            num /= 10;
        }

        return answer;
    }
}
