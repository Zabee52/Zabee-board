package Baekjoon;

import java.util.Scanner;

public class AcmHotel10250 {
    /*
        지문이 긴 관계로 링크로 대체한다...
        https://www.acmicpc.net/problem/10250
        요약하자면 n * m 크기의 호텔에서 순서대로
        0 0, 1 0, 2 0, ... , n 0, n 1, ... 이렇게 방을 잡아주라는 내용이다.

        checkinNum을 층 수만큼 0이 되지 않게 뺄 수 없을 때까지 빼면 층수가 나옴!
        뺀 횟수는 방번호가 됨!
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] n = new int[cnt];

        int[] floors = new int[cnt];
        int[] rooms = new int[cnt];
        int[] checkinNum = new int[cnt];

        for(int i = 0; i < n.length; i++){
            floors[i] = sc.nextInt();
            rooms[i] = sc.nextInt();
            checkinNum[i] = sc.nextInt();
        }

        for(int i = 0; i < n.length; i++){
            int room = 1;
            while(checkinNum[i] > floors[i]){
                checkinNum[i] -= floors[i];
                room++;
            }
            int floor = checkinNum[i];


            String str = String.valueOf(floor);
            if(room < 10){
                str += "0" + room;
            }else{
                str += room;
            }
            System.out.println(str);
        }
    }
}
