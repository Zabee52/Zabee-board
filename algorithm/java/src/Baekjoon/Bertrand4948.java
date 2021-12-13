package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bertrand4948 {
    /*
        베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
        이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
        예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
        자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.

        입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
        입력의 마지막에는 0이 주어진다.

        각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.

        https://www.acmicpc.net/problem/4948

        제한시간이 1초라 일반적인 방법으로 풀어나갈 경우 123,456^2 횟수 만큼의 연산을 시행해야한다.
        여기서 써야하는게 에라토스테네스의 체인데, 소수를 직접 구할 수는 없어도 소수가 아닌 수는 구할 수 있다는 논리로 구간 내의 소수가 아닌 수는 전부 사전에 체크를 해주는 것이다.

        에라토스테네스의 체를 쓸 때 실수로 sqrt를 안 해줘서 좀 걸렸다. 쓸 줄만 알면 금방 푼다.
     */


    static boolean[] primeArr = new boolean[246912 + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        getPrime();

        int inputNum = -1;
        while (true) {
            inputNum = sc.nextInt();
            if (inputNum == 0) {
                break;
            }
            list.add(inputNum);
        }

        for (Integer val : list) {
            int cnt = 0;
            // 입력받은 수보다 1 큰 값 <= n <= 입력받은 수 * 2
            // 이 사이엔 소수가 무조건 하나 이상 있다는 뜻
            for (int k = val + 1; k <= val * 2; k++) {
                if (primeArr[k]) {
                    continue;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static void getPrime() {
        // 0 과 1 은 소수가 아니므로 true
        // 에라토스테네스의 체 썼음!
        primeArr[0] = true;
        primeArr[1] = true;

        for (int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            if (primeArr[i]) {
                continue;
            }
            for (int k = i * i; k < primeArr.length; k += i) {
                primeArr[k] = true;
            }
        }
    }
}
