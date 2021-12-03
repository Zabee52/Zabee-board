package Baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Josep11866 {
    /*
        요세푸스 문제는 다음과 같다.
        1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
        이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
        이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
        예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
        N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

        첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

        예제와 같이 요세푸스 순열을 출력한다.
        입력 7, 3
        출력 <3, 6, 2, 7, 5, 1, 4>

        https://www.acmicpc.net/problem/11866

        deque를 순환시키는 방식을 알면 그냥 순차적으로 풀어내면 되는 문제다. 심플하다.
     */

    public static void main(String[] args) {
        // N의 배열에서 K번째 사람을 계속 지워나가는 알고리즘
        // LinkedList 쓰면 되지 않을까?
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        LinkedList<Integer> deque = new LinkedList<>();

        initDeque(deque, n);

        StringBuilder sb = new StringBuilder("<");
        while (!deque.isEmpty()) {
            int res = cycleDeque(deque, k);
            sb.append(res);
            if (deque.size() > 0) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }

    private static int cycleDeque(LinkedList<Integer> deque, int k) {
        for (int i = 0; i < k - 1; i++) {
            deque.add(deque.poll());
        }
        return deque.poll();
    }
    private static void initDeque(LinkedList<Integer> deque, int n) {
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
    }
}
