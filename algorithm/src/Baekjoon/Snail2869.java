package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Snail2869{
    /*
       땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
       달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
       달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

       첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

       첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

       https://www.acmicpc.net/problem/2869


       문제 푸는 것보다 입력시간 단축시키는게 더 관건인 문제다. 허허
     */
    public static void main(String[] args) throws IOException{
        /*
            달팽이는 낮에 A 오르고, 밤에 B 미끄러진다
            하루에 오를 수 있는 높이는 A-B.
            올라야하는 높이는 V.

            V = 일수 * (A-B)
            일수 = V / (A-B)

            B만큼 오버했다고 계산했을때가 위의 수식
            (V-B) / (A-B)

            !! (V-B)%(A-B) != 0 이라는 뜻은, (V-B)/(A-B)일만큼 오르고도 (A-B) 이하의 높이가 남았다는 뜻. = 다음날 낮에 정상에 오름. 그래서 +1
            A = 3 B = 1 V = 8 대입해보면, 7 % 2 != 0 이므로 7/2 + 1 = 4(정답)
            A = 3 B = 1 V = 11 대입해보면, 10 % 2 == 0 이므로 10/2 = 5(정답)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.println( (v-b)%(a-b)==0 ? (v-b)/(a-b) : (v-b)/(a-b)+1 );
    }
}