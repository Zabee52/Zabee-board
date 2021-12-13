package Baekjoon;

import java.io.*;

public class SugarDelivery2839 {
    /*
        상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
        설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
        상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
        예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
        상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

        첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

        상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

        https://www.acmicpc.net/problem/2839
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = n/5;

        switch(n%5){
            case 0: break;
            case 1: case 3: cnt++; break;  // n % 5가 1 또는 3인 경우 : 6, 8, 11, 13. 5를 하나 빼고 3을 두 개 더해줘야함(n/5-1+2) = cnt++
            case 2: case 4: cnt+=2; break; // n % 5가 2 또는 4인 경우 : 7, 9, 12, 14. 5를 하나 빼고 3을 세 개 더해줘야함(n/5-1+3) = cnt+=2
        }

        switch(n){
            case 4: case 7: cnt = -1; break;
        }

        System.out.println(cnt);
    }
}
