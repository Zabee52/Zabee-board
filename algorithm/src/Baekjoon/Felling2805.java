package Baekjoon;

import java.util.Scanner;

public class Felling2805 {
    /*
        상근이는 나무 M미터가 필요하다. 근처에 나무를 구입할 곳이 모두 망해버렸기 때문에, 정부에 벌목 허가를 요청했다.
        정부는 상근이네 집 근처의 나무 한 줄에 대한 벌목 허가를 내주었고, 상근이는 새로 구입한 목재절단기를 이용해서 나무를 구할것이다.
        목재절단기는 다음과 같이 동작한다. 먼저, 상근이는 절단기에 높이 H를 지정해야 한다.
        높이를 지정하면 톱날이 땅으로부터 H미터 위로 올라간다.
        그 다음, 한 줄에 연속해있는 나무를 모두 절단해버린다.
        따라서, 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것이다.
        예를 들어, 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자.
        상근이가 높이를 15로 지정했다면, 나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것이다. (총 7미터를 집에 들고 간다)
        절단기에 설정할 수 있는 높이는 양의 정수 또는 0이다.
        상근이는 환경에 매우 관심이 많기 때문에, 나무를 필요한 만큼만 집으로 가져가려고 한다.
        이때, 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오.

        첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
        둘째 줄에는 나무의 높이가 주어진다. 나무의 높이의 합은 항상 M보다 크거나 같기 때문에, 상근이는 집에 필요한 나무를 항상 가져갈 수 있다.
        높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0이다.


        환경에 매우 관심이 많다면서 20억.....? 나무를 하나하나 벌목하는게 아니라 한꺼번에 자르고 나머지는 버려.....?

        하루종일 이 문제만 풀었다... min값을 설정하는 어처구니없는 실수로 이렇게 돼버렸다... 그렇게 됐습니다...
        https://www.acmicpc.net/problem/2805
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        for(int i = 0; i < N; i++) {
            tree[i] = in.nextInt();

            /*
             * 나무들 중 최댓값을 구하기 위해 매 입력 때마다 max 변수와 비교하여
             * 입력 받은 나무가 max보다 클 경우 max 값을 해당 나무의 높이로 갱신해준다.
             */
            if(max < tree[i]) {
                max = tree[i];
            }
        }

        // 이분 탐색 (upper bound)
        while(min < max) {

            int mid = (min + max) / 2;
            long sum = 0;
            for(int treeHeight : tree) {

                /*
                 *  tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
                 *  tree의 잘린 길의의 합을 구한다.
                 *  이 때 자르는 위치가 주어진 나무의 높이보다 클 수 있기 때문에
                 *  0 이하인 경우(=음수)에는 합산을 하지 않고 양수만 합산하도록 해야한다.
                 */
                if(treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }


            /*
             * 자른 나무 길의의 합이 M보다 작다는 것은
             * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
             * 즉, 상한(max)를 줄여야 한다.
             */
            if(sum < M) {
                max = mid;
            }

            /*
             * 자른 나무 길이의 합이 M보다 크다는 것은
             * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
             * 또한, 같을 경우에는 최대한 적게 자르기 위해 자르는 높이를
             * 높여야 하므로 하한(min)을 올려야 한다.
             */
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }
}






//    아래는 이분탐색 알고리즘에 대해 잘 모르는 채로 풀어서 완전 꼬인 코드. 폐기했습니다
    // 이 코드의 문제점 : 값이 같을때 처리가 안 됨
//    static long remainM = -1000000000;
//    static long thatH = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        // 나무의 수 N
//        int n = sc.nextInt();
//        // 가져갈 나무의 길이 M
//        long m = sc.nextInt();
//        // 나무의 높이들 tree_h
//        int[] tree_h = new int[n];
//        // 이분탐색을 위한 변수 선언
//        int maxHeight = 0;
//        int minHeight = 1000000000;
//        // 톱날의 높이 h
//        int h = 0;
//
//        for (int i = 0; i < n; i++) {
//            tree_h[i] = sc.nextInt();
//            if (tree_h[i] > maxHeight) {
//                maxHeight = tree_h[i];
//            }
//            if (tree_h[i] < minHeight) {
//                minHeight = tree_h[i];
//            }
//        }
//        // 나무 높이의 평균값을 가짐
//        h = (maxHeight + minHeight) / 2;
//        if (minHeight == maxHeight) {
//            if(!(tree_h[0]*n == m)){
//                thatH = (tree_h[0]*n) / m;
//            }
//        }
//
//        /*
//            1. 중간값으로 먼저 자름
//            2. 원하는만큼 얻는데 성공했으면 min = h; h = (max+min)/2;
//            2-1. 실패했으면 max = h; h = (max+min)/2;
//            3. 성공했을시 남은 m이 가장 높은값을 remainM에 저장하고 당시의 높이값을 thatH에 저장.
//         */
//        while (maxHeight != minHeight) {
//            if (felling(m, tree_h, h)) {
//                minHeight = h + 1;
//            } else {
//                maxHeight = h-1;
//            }
//            h = (maxHeight + minHeight) / 2;
//        }
//
//        if (n == 1) {
//            thatH = tree_h[0] - m;
//        }
//        System.out.println(thatH);
//    }
//
//    static boolean felling(long m, int[] tree_h, int h) {
//        boolean result = false;
//
//        for (int i = 0; i < tree_h.length; i++) {
//            if (tree_h[i] <= h) {
//                continue;
//            } else {
//                m -= tree_h[i] - h;
//            }
//        }
//        if (m <= 0) {
//            if (m > remainM) {
//                remainM = m;
//                thatH = h;
//            }
//            result = true;
//        }
//        System.out.println("H가 " + h + "일 때의 M : " + m);
//        return result;
//    }
//
//}