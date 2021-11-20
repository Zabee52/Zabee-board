package Programmers;

public class MininumSquare86491{
    /*
        가로크기 중 최댓값, 세로크기 중 최댓값인 직사각형의 넓이를 반환하는 문제이다.
        세로가 가로보다 클 경우 회전시켜 사이즈를 맞출 수 있다는 점을 알아두자.
        변수간 값을 교환하는 방법을 알고 있다면 어렵지 않게 풀 수 있을 것이다.
        https://programmers.co.kr/learn/courses/30/lessons/86491
     */
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_width = 0;
        int max_height = 0;

        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if(sizes[i][0] > max_width){
                max_width = sizes[i][0];
            }
            if(sizes[i][1] > max_height){
                max_height = sizes[i][1];
            }
        }

        answer = max_width * max_height;
        return answer;
    }
}
