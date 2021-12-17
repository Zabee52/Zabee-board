input = 100


# 피보나치 수열 구하기
# 1 1 2 3 5 8 13 21 34 .....
# 20번째를 구한다 치면.....
#
def fibo_recursion(n):
    if n <= 2:
        return 1
    return fibo_recursion(n-1) + fibo_recursion(n-2)


print(fibo_recursion(input))  # 6765