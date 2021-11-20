package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class ModulerDivisor12910 {
    /*
        arr 속 데이터중 divisor로 나누어 떨어지는 값만 배열에 새로 담아 오름차순 정렬하는 문제이다.
        % 연산자의 사용법, 그리고 새로운 변수에 값을 담아내고 정렬하는 것까지 하면 끝이다.
        삽입할 때 정렬이 되어 들어가는 방식(PriorityQueue, HashSet)을 써도 된다.
        https://programmers.co.kr/learn/courses/30/lessons/12910
     */
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }

        if(list.size() == 0){
            list.add(-1);
        }
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}
