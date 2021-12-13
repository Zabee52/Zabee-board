package Baekjoon;

import java.util.Scanner;

public class Regist1076 {
    /*
        전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다. 처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다. 저항의 값은 다음 표를 이용해서 구한다.
        색 	    값 	곱
        black 	0 	1
        brown 	1 	10
        red 	2 	100
        orange 	3 	1,000
        yellow 	4 	10,000
        green 	5 	100,000
        blue 	6 	1,000,000
        violet 	7 	10,000,000
        grey 	8 	100,000,000
        white 	9 	1,000,000,000

        예를 들어, 저항의 색이 yellow, violet, red였다면 저항의 값은 4,700이 된다.

        첫째 줄에 첫 번째 색, 둘째 줄에 두 번째 색, 셋째 줄에 세 번째 색이 주어진다. 위의 표에 있는 색만 입력으로 주어진다.
        입력으로 주어진 저항의 저항값을 계산하여 첫째 줄에 출력한다.
     */

    public static void main(String[] args){
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        String[] value = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] multiple = {"", "0", "00", "000", "0000", "00000", "000000", "0000000", "00000000", "000000000"};

        Scanner sc = new Scanner(System.in);

        String[] vals = new String[3];
        for(int i = 0; i < vals.length; i++){
            vals[i] = sc.nextLine();
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < colors.length; k++){
            if(vals[0].equals("black")){
                vals[0] = "";
                break;
            }
            vals[0] = vals[0].replaceAll(colors[k], value[k]);
        }
        sb.append(vals[0]);

        for(int k = 0; k < colors.length; k++){
            if(sb.toString().equals("") && vals[1].equals("black") ){
                vals[1] = "";
                break;
            }
            vals[1] = vals[1].replaceAll(colors[k], value[k]);
        }
        sb.append(vals[1]);

        for(int i = 0; i < colors.length; i++){
            if(sb.toString().equals("")){
                vals[2] = "0";
                break;
            }
            vals[2] = vals[2].replaceAll(colors[i], multiple[i]);
        }
        sb.append(vals[2]);

        System.out.println(sb);
    }
}
