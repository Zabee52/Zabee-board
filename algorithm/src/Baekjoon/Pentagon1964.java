package Baekjoon;

import java.util.Scanner;

public class Pentagon1964 {
    /*
        오각형의 각 변에 아래 그림과 같이 점을 찍어 나간다. N단계에서 점의 개수는 모두 몇 개일까?

        첫째 줄에 N(1 ≤ N ≤ 10,000,000)이 주어진다.

        첫째 줄에 N단계에서 점의 개수를 45678로 나눈 나머지를 출력한다.

        https://www.acmicpc.net/problem/1964

        어렵게 생각했는데 너무 쉬운 문제였다.. 켁;;
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long sum = 5;
        for (int i = 2; i <= n; i++) {
            sum += (i+1) + (i*2);
        }
        System.out.println(sum%45678);
    }
}
