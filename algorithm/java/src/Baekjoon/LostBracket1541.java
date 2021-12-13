package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LostBracket1541 {
    /*
        세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
        그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
        괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

        첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
        그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.
        입력으로 주어지는 식의 길이는 50보다 작거나 같다.

        첫째 줄에 정답을 출력한다.

        https://www.acmicpc.net/problem/1541

        문제의 요구조건은 심플하다.
        -다음에 있는 모든 +에 괄호를 치면 되는거다.

        근데 이 조건을 만족하는 식을 찾는것이 어려웠다.

        내가 했던 방법은
        1. '-' 부호의 처리 차례일 때
        2. '-' 다음 부호가 '+'일 경우 괄호('(')를 씌운다.
        3. 부호가 '+'이 아닌 지점을 만날 때까지 반복한다.
        ex) 1+2-3+4+5+6-7+8-9-10 -> 1+2-(3+4+5+6)-(7+8)-9-10 = -49 (최솟값)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 받은 문자열을 분해해서 숫자와 부호로 나눠줄것임.
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();

        String nums = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-' || c == '+') {
                opList.add(c);
                numList.add(Integer.parseInt(nums));
                nums = "";
            } else {
                nums += c;
            }
        }
        numList.add(Integer.parseInt(nums));

        int total = numList.get(0);
        for (int i = 0; i < opList.size(); i++) {
            if (opList.get(i) == '-') {
                if ((i < opList.size() - 1) && (opList.get(i + 1) == '+')) {
                    // - 뒤에 있는 더하기들은 전부 괄호로 처리
                    do {
                        total -= numList.get(i + 1);
                        i++;
                    } while (i < opList.size() && opList.get(i) == '+');
                    // 마지막 while이 -를 만나고 나면 마이너스 연산을 증감식에서 스킵하지 않기 위해 인덱스를 한 번되돌려줘야함.
                    i--;
                } else {
                    total -= numList.get(i + 1);
                }
            } else {
                total += numList.get(i + 1);
            }
        }
        System.out.println(total);
    }
}
