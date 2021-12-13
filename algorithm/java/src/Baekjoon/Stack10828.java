package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack10828 {
    /*
        정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
        명령은 총 다섯 가지이다.
        push X: 정수 X를 스택에 넣는 연산이다.
        pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 스택에 들어있는 정수의 개수를 출력한다.
        empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
        top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

        첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
        둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
        주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
        문제에 나와있지 않은 명령이 주어지는 경우는 없다.

        Stack의 기능들을 알고 있다면 정말정말 쉽게 풀 수 있다.
        하지만 주의할 점은 제한시간이 추가시간 없는 0.5초기 때문에 Scanner로는 시간내로 수행할 수 없는 점,
        그렇기 때문에 BufferedReader를 사용해야하는점을 알아두자.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        List<String> commands = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(sc.readLine());

        for (int i = 0; i < n; i++) {
            // 명령어 저장
            commands.add(sc.readLine());
        }

        for (int i = 0; i < commands.size(); i++) {
            /*
                push : push()
                pop : pop()
                size : size()
                empty : isEmpty()
                top : peek()
             */
            String command = commands.get(i);
            if (command.contains("push")) {
                stack.push(command.split(" ")[1]);
            } else if (command.equals("pop")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                System.out.println(stack.isEmpty() ? "1" : "0");
            } else if (command.equals("top")) {
                System.out.println(stack.isEmpty() ? "-1" : stack.peek());
            }
        }
    }
}