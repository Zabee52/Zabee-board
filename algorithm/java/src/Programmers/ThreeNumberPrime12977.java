package Programmers;

public class ThreeNumberPrime12977 {
    // 배열 속 숫자 세 개를 더했을 때 소수인 수의 목록을 출력하는 알고리즘이다.
    // 풀 때 사중포문을 썼는데 별다른 방안은 없는 것 같다.
    // https://programmers.co.kr/learn/courses/30/lessons/12977

    public boolean isPrime(int num){
        boolean result = true;

        // 소수 : 2 ~ (자기자신-1) 까지 나눈 나머지가 0인 경우가 없으면 소수
        for(int i = 2; i < num; i++){
            if(num % i == 0){
                result = false;
                break;
            }
        }

        return result;
    }

    public int solution(int[] nums) {
        int answer = 0;

        // 삼중 for문을 보니 마음이 너무나도 불편하다.....
        for (int i = 0; i < nums.length - 2; i++) {
            for (int k = i + 1; k < nums.length - 1; k++) {
                for (int m = k + 1; m < nums.length; m++) {
                    int sum = nums[i] + nums[k] + nums[m];

                    // 소수일 경우 개수 증가
                    if(isPrime(sum)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
