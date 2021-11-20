package Programmers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateExam12901 {
    // LocalDate는 처음 써보는거라 친해져야할 필요가 있는 것 같다.
    // https://programmers.co.kr/learn/courses/30/lessons/12901

    public String solution(int a, int b) {
        String answer = "";
        LocalDate targetDate = LocalDate.of(2016,a,b);
        // .ofPattern("E") : 한국일경우 월, 화, 수, ... 형식으로 출력
        // .withLocale(Locale.forLanguageTag("en") : 언어를 영어로 설정. Mon, Tue, Wed, ... 형식으로 출력
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("E").withLocale(Locale.forLanguageTag("en"));

        // 문제의 조건은 MON, TUE, WED, ... 형식으로 출력하는 것이었기 때문에 toUpperCase 적용
        answer = dateTimeFormatter.format(targetDate).toUpperCase();

        return answer;
    }
}
