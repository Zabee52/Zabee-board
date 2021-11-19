package Programmers;

public class PhoneNumberSecurity {
    // 뒷자리 4자리만 별표로 숨기기
    // https://programmers.co.kr/learn/courses/30/lessons/12948

    public String solution(String phone_number) {
        String answer = "";
        int v = 4;
        int pointer = phone_number.length() - v;

        for(int i = 0; i < pointer; i++){
            answer += "*";
        }

        answer += phone_number.substring(pointer, pointer + v);

        return answer;
    }
}
