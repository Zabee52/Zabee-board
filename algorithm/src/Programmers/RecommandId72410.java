package Programmers;

import java.util.ArrayList;
import java.util.List;

public class RecommandId72410 {
    // 스텝을 밟아나가며 처리해주면 되는 문제이지만 양이 많아서 꽤나 오래걸리는 문제다.
    // 이런건 반복숙달로 속도를 끌어올리는 것 말고는 뾰족한 수가 없을 것 같다.
    // https://programmers.co.kr/learn/courses/30/lessons/72410

    public void removeFullStop(List<Character> list) {
        if(list.size() > 0 && list.get(0) == '.'){
            list.remove(0);
        }
        if(list.size() > 0 && list.get(list.size()-1) == '.'){
            list.remove(list.size() - 1);
        }
    }

    public String solution(String new_id) {
        String answer = new_id;
        List<Character> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        // 1단계: new_id의 모든 대문쟈를 대응되는 소문자로 치환
        answer = answer.toLowerCase();
        // 2단계: 알파벳 소문자, 숫자, 하이픈, 언더바, 마침표를 제외한 모든 문자 제거
        char[] chars = answer.toCharArray();
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') ||
                    (c >= '0' && c <= '9') ||
                    c == '-' || c == '_' || c == '.') {
                list.add(c);
            }
        }

        // 3단계: 마침표가 두 번 이상 연속되면 하나의 마침표로 치환
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == '.') {
                if (list.get(i) == list.get(i + 1)) {
                    list.remove(i);
                    i = -1;
                }
            }
        }

        // 4단계: 마침표가 처음이나 끝에 있으면 제거
        removeFullStop(list);

        // 5단계: 빈 문자열일 경우 new_id에 a를 대입
        if (list.size() == 0) {
            list.add('a');
        }

        // 6단계: 문자열의 길이가 16자 이상일 경우 15문자를 제외하고 전부 제거
        // 이후 5단계 한 번 더 시행
        if(list.size() >= 16){
            list = list.subList(0, 15);
            removeFullStop(list);
        }

        // 7단계: 길이가 2자 이하인 경우 마지막 문자를 길이가 3이 될 때까지 반복
        if(list.size() <= 2){
            while(list.size() < 3){
                list.add(list.get(list.size()-1));
            }
        }

        for (Character ch : list) {
            builder.append(ch);
        }

        return builder.toString();
    }
}
