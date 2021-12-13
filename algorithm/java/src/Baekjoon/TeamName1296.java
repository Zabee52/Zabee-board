package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class TeamName1296 {
    /*
        연두는 프로그래밍 대회에 나갈 팀 이름을 정하려고 한다. 미신을 믿는 연두는 이환이에게 공식을 하나 받아왔고, 이 공식을 이용해 우승할 확률이 가장 높은 팀 이름을 찾으려고 한다.
        이환이가 만든 공식은 사용하려면 먼저 다음 4가지 변수의 값을 계산해야 한다.
            L = 연두의 이름과 팀 이름에서 등장하는 L의 개수
            O = 연두의 이름과 팀 이름에서 등장하는 O의 개수
            V = 연두의 이름과 팀 이름에서 등장하는 V의 개수
            E = 연두의 이름과 팀 이름에서 등장하는 E의 개수
        그 다음, 위에서 구한 변수를 다음 식에 입력하면 팀 이름의 우승할 확률을 구할 수 있다.
        ((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100
        연두의 영어 이름과 팀 이름 후보 N개가 주어졌을 때, 우승할 확률이 가장 높은 팀 이름을 구해보자. 확률이 가장 높은 팀이 여러가지인 경우 사전 순으로 가장 앞서는 팀 이름이 우승할 확률이 가장 높은 것이다.

        첫째 줄에 연두의 영어 이름이 주어진다. 둘째 줄에는 팀 이름 후보의 개수 N이 주어진다. 셋째 줄부터 N개의 줄에 팀 이름이 한 줄에 하나씩 주어진다.
        연두의 영어 이름과 팀 이름은 길이는 1보다 크거나 같고, 20보다 작거나 같으며, 알파벳 대문자로만 이루어져 있다. N은 50보다 작거나 같은 자연수이다.

        첫째 줄에 우승할 확률이 가장 높은 팀 이름을 출력한다.

        https://www.acmicpc.net/problem/1296


        별거 아닌주제에 라인은 많이 잡아먹는 흉악한 문제였다..... 게다가 문제 이해를 잘못해서 이름과 일치하는 팀명으로 탐색했는데 안 돼서 그걸로 시간 날렸다.....
        허허..
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        String[] teamNames = new String[n];
        for (int i = 0; i < n; i++) {
            teamNames[i] = sc.nextLine();
        }
        Arrays.sort(teamNames);

        int[] nameCnt = new int[4];
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'L') {
                nameCnt[0]++;
            }
            if (name.charAt(i) == 'O') {
                nameCnt[1]++;
            }
            if (name.charAt(i) == 'V') {
                nameCnt[2]++;
            }
            if (name.charAt(i) == 'E') {
                nameCnt[3]++;
            }
        }

        int[][] teamNameCnt = new int[n][4];
        for (int i = 0; i < n; i++) {
            teamNameCnt[i][0] = nameCnt[0];
            teamNameCnt[i][1] = nameCnt[1];
            teamNameCnt[i][2] = nameCnt[2];
            teamNameCnt[i][3] = nameCnt[3];
        }


        for (int i = 0; i < teamNames.length; i++) {
            for (int k = 0; k < teamNames[i].length(); k++) {
                if (teamNames[i].charAt(k) == 'L') {
                    teamNameCnt[i][0]++;
                }
                if (teamNames[i].charAt(k) == 'O') {
                    teamNameCnt[i][1]++;
                }
                if (teamNames[i].charAt(k) == 'V') {
                    teamNameCnt[i][2]++;
                }
                if (teamNames[i].charAt(k) == 'E') {
                    teamNameCnt[i][3]++;
                }
            }
        }

//        for (int i = 0; i < teamNames.length; i++) {
//            System.out.print(teamNames[i] + " : ");
//            System.out.print(teamNameCnt[i][0] + " " + teamNameCnt[i][1] + " " + teamNameCnt[i][2] + " " + teamNameCnt[i][3]);
//            System.out.println();
//        }

        int[] sum = new int[n];
        Arrays.fill(sum, 1);

        for(int i = 0; i < teamNameCnt.length; i++){
//            System.out.print(teamNames[i] + " : " );
            for(int k = 0; k < teamNameCnt[i].length-1; k++){
                for(int m = k+1; m < teamNameCnt[i].length; m++){
                        sum[i] *= teamNameCnt[i][k] + teamNameCnt[i][m];
//                        System.out.print("(" + teamNameCnt[i][k] + " + " + teamNameCnt[i][m] + ") * ");
                }
            }
//            System.out.println(" = " + sum[i]%100);
            sum[i] %= 100;
        }

        int max = 0;
        int max_idx = 0;
        for(int i = 0; i < n; i++){
            if(sum[i] > max){
                max = sum[i];
                max_idx = i;
            }
        }

        System.out.println(teamNames[max_idx]);
    }
}
