package Programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ThatSong17683v2 {
    /*
        방금그곡 서비스에서는 음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공한다.
        네오가 기억한 멜로디와 악보에 사용되는 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개이다.
        각 음은 1분에 1개씩 재생된다. 음악은 반드시 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 음악이 끊김 없이 처음부터 반복해서 재생된다.
        음악 길이보다 재생된 시간이 짧을 때는 처음부터 재생 시간만큼만 재생된다.
        음악이 00:00를 넘겨서까지 재생되는 일은 없다.
        조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다.
        재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
        조건이 일치하는 음악이 없을 때에는 “(None)”을 반환한다.

        입력으로 네오가 기억한 멜로디를 담은 문자열 m과 방송된 곡의 정보를 담고 있는 배열 musicinfos가 주어진다.
        m은 음 1개 이상 1439개 이하로 구성되어 있다.
        musicinfos는 100개 이하의 곡 정보를 담고 있는 배열로, 각각의 곡 정보는 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보가 ','로 구분된 문자열이다.
        음악의 시작 시각과 끝난 시각은 24시간 HH:MM 형식이다.
        음악 제목은 ',' 이외의 출력 가능한 문자로 표현된 길이 1 이상 64 이하의 문자열이다.
        악보 정보는 음 1개 이상 1439개 이하로 구성되어 있다.
        https://programmers.co.kr/learn/courses/30/lessons/17683
     */

    public String solution(String m, String[] musicinfos) {
        // String to LocalDateTime Format 변환을 위한 부분
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
        String result = "(None)";
        long resultTime = -1;

        // # 붙은 문자열들 모두 치환하기
        m = changeSharp(m);

        for (String musicinfo : musicinfos) {
            String[] splitInfo = musicinfo.split(",");
            LocalTime start = LocalTime.parse(splitInfo[0], formatter);
            LocalTime end = LocalTime.parse(splitInfo[1], formatter);
            int playTime = (int) ChronoUnit.MINUTES.between(start, end);
            String name = splitInfo[2];
            StringBuilder melody = new StringBuilder();
            // # 붙은 문자열들 모두 치환하기
            splitInfo[3] = changeSharp(splitInfo[3]);

            // 23:59 ~ 00:01 과 같이 다음날로 넘어가는 경우 하루(1440)을 더해서 계산
            if (playTime < 0) {
                playTime += 1440;
            }


            int melodyLen = splitInfo[3].length();

            if (playTime > melodyLen) {
                // 음악의 플레이타임보다 음악이 짧을 경우
                // 반복재생 길이만큼 melody 늘리기.
                melody.append(splitInfo[3].repeat(playTime / melodyLen));
                // 나머지 문자열 뒤에 붙이기.
                melody.append(splitInfo[3], 0, playTime % splitInfo[3].length());
            } else {
                // 음악의 플레이타임보다 음악이 길 경우
                melody.append(splitInfo[3], 0, playTime);
            }

            // 일치하는 음악 탐색
            // AAB를 찾고싶을 때 AAB#이 있으면 문제가 발생함. 찾는 문자열 뒤에 #이 붙은건 전부 제거함.
            if (melody.toString().contains(m) && playTime > resultTime) {
                result = name;
                resultTime = playTime;
            }
        }

        return result;
    }

    private String changeSharp(String m) {
        String result = m;

        //c# d# f# g# a# 변환
        result = result.replaceAll("C#", "H");
        result = result.replaceAll("D#", "I");
        result = result.replaceAll("F#", "J");
        result = result.replaceAll("G#", "K");
        result = result.replaceAll("A#", "L");

        return result;
    }

    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m4 = "DF";
        String[] musicinfos4 = {"06:20,06:52,TEST,DDF"};

        String m5 = "ABC#D#";
        String[] musicinfos5 = {"03:00,03:4,FOO,ABC#D#", "04:00,04:10,BAR,ABC#D#"};

        String m6 = "CCB";
        String[] musicinfos6 = {"23:59,00:02,FOO,CCB", "02:00,02:03,BAR,CCB"};

        ThatSong17683v2 s = new ThatSong17683v2();

        System.out.println(s.solution(m5, musicinfos5));
    }
}