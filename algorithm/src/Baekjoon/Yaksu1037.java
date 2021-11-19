package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Yaksu1037 {
    // 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
    // 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.

    // 지문 이해가 문제보다 어려웠던 문제..
    // 그냥 목록 정렬하고 가장 낮은수랑 가장 높은수 곱해주면 됨
    // 입력받은 약수의 개수가 1개라고 그 값을 그대로 출력해주면 안 됨! 여기서 엄청 헤멨다. 아니 사실 그냥 지문이 개판인 것 같다.....

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        int min = list.get(0);
        int max = list.get(list.size()-1);

        long res = min * max;
        System.out.println(res);
    }
}
