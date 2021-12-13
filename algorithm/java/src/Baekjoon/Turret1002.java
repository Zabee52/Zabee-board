package Baekjoon;

import java.util.Scanner;

public class Turret1002 {
    /*
        조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
        이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
        조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
        조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
        조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
        류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.

        첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 이루어져 있다.
        한 줄에 x1, y1, r1, x2, y2, r2가 주어진다.
        x1, y1, x2, y2는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.

        각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다. 만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
     */

    public static void main(String[] args){
        // 서로에게 좌표가 주어졌을 때 대상이 존재할 수 있는 좌표의 경우의 수를 구하기
        // 파이 써야하나?
        // 거리를 기준으로 원을 그어 합친다고 하면 경우의수는 다음과 같다
        // 정확히 일치하면 : 경우의수 무한. -1 출력
        // 교점이 2개일 경우 : 2 출력
        // 교점이 1개일 경우 : 1 출력
        // 교점이 없을 경우 : 0 출력
        // 받은 수로 원을 그렸을 때 그 길이가 일치하고 만나는 지점도 일치하면 1.
        // 결국 삼각함수를 썼다.

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] cho = new int[t][3];
        int[][] paek = new int[t][3];

        for(int i = 0; i < t; i++){
            cho[i][0] = sc.nextInt();   //x1
            cho[i][1] = sc.nextInt();   //y1
            cho[i][2] = sc.nextInt();   //r1
            paek[i][0] = sc.nextInt();  //x2
            paek[i][1] = sc.nextInt();  //y2
            paek[i][2] = sc.nextInt();  //r2
        }

        for(int i = 0; i < t; i++){
            // 비교할 때 삼각함수를 쓸 것임 (a^2 + b^2 = c^2)
            // 그러기 위해 편의를 위해 먼저 a^2+b^2를 구해놓음.
            int distance = (int) (Math.pow(cho[i][0]-paek[i][0], 2) + Math.pow(cho[i][1] - paek[i][1], 2));

            if(cho[i][0] == paek[i][0] && cho[i][1] == paek[i][1] && cho[i][2] == paek[i][2]){
                // 정확히 일치하면 무한히 겹치므로 -1 출력.
                System.out.println(-1);
            }else if(distance > Math.pow(cho[i][2] + paek[i][2], 2) ||
                    (distance < Math.pow(cho[i][2] - paek[i][2], 2))){
                // cho와 paek의 거리(|x1-x2| + |y1-y2|)가 r의 합보다 클 때 = 원이 서로 만나지 않을 때.
                // cho와 peak의 거리가 r사이의 거리보다 작을 때 = 원이 겹치지만 크기가 달라 만날 수 없을 때
                System.out.println(0);
            }else if(distance == Math.pow(cho[i][2] + paek[i][2],2) ||
                    distance == Math.pow(cho[i][2] - paek[i][2],2)){
                // cho와 paek의 거리가 r의 합과 같을 때 = 원이 외접할 때(한 점에서 외부에서 만날 때)
                // cho와 paek의 거리가 r 사이의 거리와 같을 때 = 원이 내접할 때(한 점에서 내부에서 만날 때)
                System.out.println(1);
            }else{
                // 그 외의 경우
                // cho와 paek의 거리가 r의 합보다 작을 때 = 교점이 두 개 생기는 원(교집합 모양) 발생
                // cho와 paek의 거리가 r 사이의 거리보다 클 때 = 중점은 가운데지만 겹치는 원의 형태 발생
                System.out.println(2);
            }
        }

    }
}
