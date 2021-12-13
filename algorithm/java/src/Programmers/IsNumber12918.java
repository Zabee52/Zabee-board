package Programmers;

public class IsNumber12918 {
    // 문자열인지 판별하는 알고리즘
    // try ~ catch 구문을 써서 풀었다.
    // https://programmers.co.kr/learn/courses/30/lessons/12918

    public boolean d(String s){
        boolean result = false;

        if(s.length() == 4 || s.length() == 6){
            try{
                int test = Integer.parseInt(s);
                result = true;
            }catch(NumberFormatException e){

            }
        }

        return result;
    }

    public boolean solution(String s) {
        boolean answer = d(s);

        return answer;
    }
}
