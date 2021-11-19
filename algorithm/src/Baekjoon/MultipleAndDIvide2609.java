package Baekjoon;

import java.util.Scanner;

public class MultipleAndDIvide2609 {
    /*
        두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

        최대공약수는 낮은 수 이하면서 낮은 수와 나눈 나머지가 0이면서 높은 수와 나눈 나머지가 0인 수임!
        최소공배수는 높은 수를 multiple로 놓고 낮은 수랑 나눈 나머지가 0이 될 때까지 계속해서 multiple에서 높은 수를 더해주면 됨!
        방법만 알면 쉽게 풀 수 있다!
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        if(num1 > num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int dividor = 1;
        for(int i = num1; i >= 1; i--){
            if(num1 % i == 0 && num2 % i == 0){
                dividor = i;
                break;
            }
        }

        int multiple = num2;
        while(multiple % num1 != 0){
            multiple += num2;
        }

        System.out.println(dividor);
        System.out.println(multiple);
    }
}