package Programmers;

import java.util.ArrayList;
import java.util.List;

public class LessNumRemove12935 {
    /*
        배열 속 가장 작은 숫자를 제거하는 문제다.
        빈 배열 처리조건도 있으니 유의할 것!
        배열을 정렬하고 1번 인덱스부터 list에 삽입해줘도 풀 수 있다. 대신 시간복잡도가 조금 아쉬워짐!
        https://programmers.co.kr/learn/courses/30/lessons/12935
     */

    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int min_idx = 0;

        if(arr.length > 1){
            for(int i = 0; i < arr.length; i++){
                list.add(arr[i]);
                if(arr[min_idx] > arr[i]){
                    min_idx = i;
                }
            }
            list.remove(min_idx);
        }else{
            list.add(-1);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
