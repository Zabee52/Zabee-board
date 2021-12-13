package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackSequence1874 {
    /*
        스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
        스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
        1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
        이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
        임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
        있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
        이를 계산하는 프로그램을 작성하라.

        첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
        둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
        물론 같은 정수가 두 번 나오는 일은 없다.

        입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

        https://www.acmicpc.net/problem/1874


        생각이 조금 필요한 문제다. 첫 번째로 문제를 제대로 이해해야 하고, push와 pop 조건에 대해 숙지하고 있어야 한다.
        조건 처리도 필요한 케이스가 많이 있어서 고민 없이 손 댔다간 힘들수도 있겠다. 실수 가능성이 높은 문제인 것 같다.
        출력 조건도 손이 한 번 더 가야해서 조금 귀찮을 수 있다.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] d = new int[n];
        ArrayList<String> plusAndMinus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        // 1부터 n까지 stack에 값이 쌓임. push랑 pop을 하면서 입력받은 배열을 만들 수 있는지 체크 하는거임.
        // stack.peek() == 0 이면 그냥 push, stack.peek() < d[i]면 무조건 push. output '+'
        // peek 한 숫자가 같으면 pop. output '-'
        // 다음 숫자가 현재 peek한 나의 숫자보다 낮으면 풀이 불가능. NO 선언.
        int stackNum = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(stack.size() == 0){
                stack.push(stackNum++);
                plusAndMinus.add("+");
            }

            while (stack.peek() != d[i]){
                if (stack.peek() < d[i]) {
                    stack.push(stackNum++);
                    plusAndMinus.add("+");
                } else if (stack.peek() > d[i]) {
                    break;
                }
            }

            if (stack.peek() == d[i]) {
                stack.pop();
                plusAndMinus.add("-");
            }else{
                break;
            }
        }

        // stack.size() == 0 이라는 뜻은, 모든 수열을 잘 풀어냈다는 뜻임. 그러므로 출력. 아니면 NO.
        if (stack.size() == 0) {
            for (String str : plusAndMinus) {
                System.out.println(str);
            }
        }else{
            System.out.println("NO");
        }
    }
}
