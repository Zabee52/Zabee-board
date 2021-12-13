package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class CoordinateAlign11651 {
    /*
        2차원 평면 위의 점 N개가 주어진다.
        좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

        Arrays.sort의 다중배열 비교법 문법 제대로 알고 쓰면 무서울 게 없음!! 꼭알아두길!
     */

    public static void main(String[] args) {
        // 1. 삼각함수로 거리를 재면 될까? 일단 해봅시다. -> 문제 요구사항과 다름
        // 2. y먼저 계산하고 x계산하는식으로 가봅시다.
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[][] coordinate = new int[cnt][2];

        for (int i = 0; i < cnt; i++) {
            coordinate[i][0] = sc.nextInt();
            coordinate[i][1] = sc.nextInt();
        }

        Arrays.sort(coordinate, (arr1, arr2) ->{
            if(arr1[1] == arr2[1]){
                return Integer.compare(arr1[0], arr2[0]);
            }else{
                return Integer.compare(arr1[1], arr2[1]);
            }
        });

        for(int i = 0; i < cnt; i++){
            System.out.println(coordinate[i][0] + " " + coordinate[i][1]);
        }
    }
}
