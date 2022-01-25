# n, m = map(int, input().split())
# max = 0
# min = 0
#
#
# import java.util.Scanner;
#
# public class Main {
#      public static void main(String[] args) {
#         Scanner sc = new Scanner(System.in);
#
#         int n = sc.nextInt();
#         int m = sc.nextInt();
#         int[] trees = new int[n];
#         int max = 0;
#         int min = 0;a
#
#         for (int i = 0; i < trees.length; i++) {
#             trees[i] = sc.nextInt();
#
#             if (trees[i] > max) {
#                 max = trees[i];
#             }
#         }
#
#         //이분탐색 시작
#         while (max > min) {
#             int mid = (max + min) / 2;
#             long sum = 0;
#
#             for(int tree: trees){
#                 if (tree > mid) {
#                     sum += (tree - mid);
#                 }
#             }
#
#             if (sum < m) {
#                 max = mid;
#             } else {
#                 min = mid + 1;
#             }
#         }
#
#         System.out.println(min-1);
#     }
# }