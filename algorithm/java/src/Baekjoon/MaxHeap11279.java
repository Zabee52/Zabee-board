package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap11279 {
    /*
        널리 잘 알려진 자료구조 중 최대 힙이 있다. 최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

        1. 배열에 자연수 x를 넣는다.
        2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.

        프로그램은 처음에 비어있는 배열에서 시작하게 된다.

        첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
        다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
        만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
        x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
        입력되는 자연수는 231보다 작다.

        입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.

        https://www.acmicpc.net/problem/11279

        PriorityQueue의 Colletions.reverseOrder()를 사용해서 풀었다.
        직접 힙 구현하라고 하면... 해야지.. 뭐..
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                if(queue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.add(arr[i]);
            }
        }
    }
}
