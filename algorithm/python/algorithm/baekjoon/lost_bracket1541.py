# 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
# 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
# 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

# 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
# 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
# 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

# 첫째 줄에 정답을 출력한다.

# https://www.acmicpc.net/problem/1541

# 문제의 요지는 -과 - 사이의 값을 모두 더한다음 전체를 빼주는 것이었다. 파악하고나서는 쉬운데 알아내기까지 시간이 좀 걸릴 것 같다.

str = input()
strArr = str.split('-')
sum = []

for num in strArr:
    tempSum = 0
    numArr = num.split('+')
    for target in numArr:
        tempSum += int(target)
    sum.append(tempSum)
result = sum[0]

for num in sum[1:]:
    result -= num
print(result)