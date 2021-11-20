package Programmers;

import java.util.ArrayList;
import java.util.List;

public class MockExam42840 {
    /*
        수포자 주제에 점수 계산해보려는 파렴치한들의 점수를 계산해주는 알고리즘이다.
        나도 수포자였지만 나는 양심상 채점도 안 했다. 해서 뭐 하니. 응?
        나는 이렇게 풀었다. 다른 풀이방법도 많을 것이다
        1. 노답들의 점수 비교를 위한 크기 3의 배열을 만든다.
        2. 맞췄으면 해당 인덱스++ 해준다.
        3. 그 중 가장 점수 높은 노답을 뽑는다.
        4. 점수 높은 노답이 누구인지 구해 list에 더해준다.
        5. 출력해준다.

        점수가 동률일 수 있기 때문에 한 명만 출력해주도록 만드는것보단 약간 복잡하게 느껴졌다.
        보다 쉬운 방법도 있을 것이다.
        https://programmers.co.kr/learn/courses/30/lessons/42840
     */

    public int[] solution(int[] answers) {
        int[] nodap1 = new int[]{1, 2, 3, 4, 5};
        int[] nodap2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] nodap3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] nodaps = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == nodap1[i%nodap1.length]){
                nodaps[0]++;
            }
            if(answers[i] == nodap2[i%nodap2.length]){
                nodaps[1]++;
            }
            if(answers[i] == nodap3[i%nodap3.length]){
                nodaps[2]++;
            }
        }

        int max_score = 0;
        for(int i = 0; i < nodaps.length; i++){
            if(nodaps[i] > max_score){
                max_score = nodaps[i];
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nodaps.length; i++){
            if(nodaps[i] == max_score){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
