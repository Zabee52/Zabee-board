# 자연수 N과 정수 K가 주어졌을 때 이항 계수 (N/K)를 구하는 프로그램을 작성하시오.
# 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)
# (N/K)를 출력한다.

# https://www.acmicpc.net/problem/11050

# 이항계수 구하는 공식
# 0 <= k <= n : n! / ( k! * (n-k)! )
# k < 0       : 0
# k > n       : 0
# 하지만 조건에서 k >= 0이면서, k <= n임을 명시해줬기 때문에 고려하지 않는다.

from math import factorial

n, k = map(int, input().split())
print(int(factorial(n) / (factorial(k) * factorial(n - k))))

