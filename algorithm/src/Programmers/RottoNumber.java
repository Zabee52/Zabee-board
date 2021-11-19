package Programmers;

public class RottoNumber {
    // 로또의 순위를 출력해주는 메소드
    // 1. 로또 숫자가 0일경우 zero_cnt를 증가시킨다.
    // 2. 로또 숫자가 당첨 숫자와 일치할 경우 win_cnt를 증가시킨다.
    // 3. 당첨된 숫자의 개수 + 0인 숫자의 개수로 나온 등수를 알아낸다.
    // 4. 당첨된 숫자의 개수로만 나온 등수를 알아낸다.
    // 5. 알아낸 두 개의 값을 answer 배열에 넣어준다.
    // 흐름을 캐치하고나면 구현은 어렵지 않다.
    // https://programmers.co.kr/learn/courses/30/lessons/77484

    public int getRank(int num) {
        int result = 6;

        switch (num) {
            case 6:
                result = 1;
                break;
            case 5:
                result = 2;
                break;
            case 4:
                result = 3;
                break;
            case 3:
                result = 4;
                break;
            case 2:
                result = 5;
                break;
        }

        return result;
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int win_cnt = 0;
        int zero_cnt = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero_cnt++;
                continue;
            }
            for (int k = 0; k < win_nums.length; k++) {
                if (lottos[i] == win_nums[k]) {
                    win_cnt++;
                }
            }
        }

        answer = new int[]{getRank(win_cnt + zero_cnt), getRank(win_cnt)};

        return answer;
    }
}
