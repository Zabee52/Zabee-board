# 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
# 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
# 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.

# https://www.acmicpc.net/problem/2609

# 1. 소인수분해
# 2. 지수끼리 곱하면 최대공약수
# 3. 지수끼리 곱한거에 서로소까지 곱하면 최소공배수

# 풀이 과정
# 1. 두 수의 소인수분해를 통해 공통된 지수 구하기
# 2. 지수끼리 곱해 최대공약수 출력
# 3. 지수 구한걸로 소인수분해

def factorization_two_nums(num1, num2):
    div = 2
    factorization_list = []
    while div <= num1 and div <= num2:
        if num1 % div == 0 and num2 % div == 0:
            factorization_list.append(div)
            num1 /= div
            num2 /= div
        else:
            div += 1
    return factorization_list


def each_other_two_nums(num1, num2, factorization_list):
    mul_factories = 1

    for num in factorization_list:
        mul_factories *= num

    return [int(num1 / mul_factories), int(num2 / mul_factories)]


def get_factor(factorization_list):
    mul = 1
    for num in factorization_list:
        mul *= num
    return mul


def get_multiple(factorization_list, each_other):
    mul = get_factor(factorization_list)
    for num in each_other:
        mul *= num
    return mul


a, b = map(int, input().split())
factorization_list = factorization_two_nums(a, b)
each_other = each_other_two_nums(a, b, factorization_list)

print(get_factor(factorization_list))
print(get_multiple(factorization_list, each_other))
