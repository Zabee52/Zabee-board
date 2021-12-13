package Programmers;

public class ProcessionAdd12950 {
    /*
        행렬간 대응되는 자리끼리 덧셈하면 된다.
        [1, 2] + [3, 4] = [4, 6]
        다중 반복문 사용할 줄만 알면 된다!
        https://programmers.co.kr/learn/courses/30/lessons/12950
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int k = 0;k < arr1[i].length; k++){
                answer[i][k] = arr1[i][k] + arr2[i][k];
            }
        }
        return answer;
    }
}
