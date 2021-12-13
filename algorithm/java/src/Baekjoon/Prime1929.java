package Baekjoon;

import java.util.Scanner;

public class Prime1929 {
    // M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
    // 에라토스테네스의 체 사용법과 많이 친해지자!

    public static void main(String[] args){
        boolean[] primeArr = new boolean[10000001];
        primeCheck(primeArr);

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        for(int i = m; i <= n; i++){
            if(primeArr[i]){
                continue;
            }
            System.out.println(i);
        }
    }

    public static void primeCheck(boolean[] primeArr){
        // 소수가 아닐경우 true를 줄 거임. 기본값이 false이기 때문
        primeArr[0] = true;
        primeArr[1] = true;

        for(int i = 2; i <= Math.sqrt(primeArr.length); i++){
            if(primeArr[i]){
                continue;
            }else{
                for(int k = i * i; k < primeArr.length; k += i){
                    primeArr[k] = true;
                }
            }
        }
    }
}
