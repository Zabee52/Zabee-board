package Programmers;

public class WithoutNumberSum {
    // 0~9중 없는 숫자를 더하기
    // 0~9까지의 합(45)에서 빼면 됨
    // 쉽다. 하지만 방법을 모르면 번거로운 방법을 써야할수도 있다.
    // https://programmers.co.kr/learn/courses/30/lessons/86051

    public int solution(int[] numbers) {
        int answer = 45;
        for(int i = 0; i < numbers.length; i++)
            answer -= numbers[i];
        return answer;
    }
}
