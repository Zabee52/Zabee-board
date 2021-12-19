# IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
# 이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
# 해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며,
# 참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
# 단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다.
# 즉, + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나,
# +,* > - 또는 * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
# 수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며, 연산자가 3개라면 3! = 6가지 조합이 가능합니다.
# 만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며,
# 우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.
#
# 예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.
#
# "100-200*300-500+20"
#
# 일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면
# 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
# 대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나
# +,* > - 또는 * > +,- 처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
# 수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
# 반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만, 규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.
#
# 참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때,
# 우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.

# expression은 길이가 3 이상 100 이하인 문자열입니다.
# expression은 공백문자, 괄호문자 없이 오로지 숫자와 3가지의 연산자(+, -, *) 만으로 이루어진
# 올바른 중위표기법(연산의 두 대상 사이에 연산기호를 사용하는 방식)으로 표현된 연산식입니다. 잘못된 연산식은 입력으로 주어지지 않습니다.
# 즉, "402+-561*"처럼 잘못된 수식은 올바른 중위표기법이 아니므로 주어지지 않습니다.
# expression의 피연산자(operand)는 0 이상 999 이하의 숫자입니다.
# 즉, "100-2145*458+12"처럼 999를 초과하는 피연산자가 포함된 수식은 입력으로 주어지지 않습니다.
# "-56+100"처럼 피연산자가 음수인 수식도 입력으로 주어지지 않습니다.
# expression은 적어도 1개 이상의 연산자를 포함하고 있습니다.
# 연산자 우선순위를 어떻게 적용하더라도, expression의 중간 계산값과 최종 결괏값은 절댓값이 263 - 1 이하가 되도록 입력이 주어집니다.
# 같은 연산자끼리는 앞에 있는 것의 우선순위가 더 높습니다.

# https://programmers.co.kr/learn/courses/30/lessons/67257

# 어려운 문제였다..... 정답에 접근하는 방식이 많이 틀려서 자주 미끄러졌다.
# permutations 좋은 기능 알아갑니다~~ ^^*


# 1. expression에서 부호만 빼보기
# 2. + - * 연산자의 종류의 수 factorial 만큼의 경우의수 해보기. 비겁하게 3개 전부 안 쓰는 경우도 있다.
# 2-1. 연산자의 종류의 개수 먼저 구하기
# 2-2. 그 개수의 factorial 취해 for문 돌리기
# 2-3. 경우의 수의 종류 구하기
# 2-4. 경우의 수 우선순위가 높은 순으로 queue에 넣기
# 2-5.
# 3. 경우의수 돌며 계산하고 return max(list) 해주면 끝날 것 같긴 하다. 2를 어떻게 하지?


# 내가 풀이한 방법
# 1. 문자열에서 사용하는 연산자의 종류를 가져온다.
# 2. 문자열을 [num1, op, num2, op, num3, ...] 형식의 리스트로 분리한다.
# 3. 연산자의 종류로 for문을 도는데, 이 연산자의 종류일 경우 계산한 뒤 기존의 num1, op, num2 세 개의 자리를 연산 결과로 대체시킨다.
# -> 이렇게 하면 ex) 1 + 2 - 3 + 4 에서 우선순위가 + - 일 경우, 3 - 7 -> -4 와 같은 순서로 계산하게 된다.
# 4. 결과값을 return해서 answer 리스트에 append 해준다.
# 5. return max(answer) 하면 끝!

# 피드백
# 연산자 세 개 다 쓰는것도 속도 차이가 얼마 크지 않았던걸 보니, 굳이 연산자의 종류를 따질 필요 없이,
# operator_list = permutations(['+', '-', '*'], 3)
# 으로 해줬어도 됐을 것 같다. 쓸 데 없는 작업을 했다.

from itertools import permutations


# expression의 부호를 빼내서 연산자의 종류 구하기.
def get_operator_list(expression):
    operator_list = []
    if '+' in expression:
        operator_list.append('+')
    if '-' in expression:
        operator_list.append('-')
    if '*' in expression:
        operator_list.append('*')
    return operator_list


# 계산식을 [ n1, op1, n2, op2, n3 ... ] 형식으로 분리하기
# ex) ['1', '+', '2', '-', '3', '*']
def get_splitted_expression(expression):
    num_list = []
    temp_str = ""
    for char in expression:
        if char == '-' or char == '+' or char == '*':
            num_list.append(temp_str)
            num_list.append(char)
            temp_str = ""
        else:
            temp_str += char
    num_list.append(temp_str)
    return num_list


def calc_by_splitted_expression_and_operator_list(splitted_expression, operator_list):
    # + - *라고 가정을 해 보자......
    # 1 + 2 + 3 - 4 + 5 * 6면
    # 1 + 2 + 3 과 4 + 5를 먼저 하고 그 결과를 서로 뺀 뒤 6을 곱해줘야 한다..
    # stack을 써서 1 + 2 + 3과 4 + 5를 저장하고 pop 하면서 빼주면? 안 된다. 빼기는 교환법칙이 성립하지 않는다.
    # queue를 쓰면? 될까?
    # 결국 생각을 멈추고 무식하게 풀도록 했다..
    result = list(splitted_expression)
    # print(result)
    for op in operator_list:
        idx = 0
        # print("------", op, "------")
        while idx < len(result):
            if result[idx] == op:
                # result[idx] == op : 현재 작업해야하는 연산자임. 연산하면 됨
                num1 = result.pop(idx - 1)
                result.pop(idx - 1)
                num2 = result.pop(idx - 1)
                now_expression = str(num1) + op + str(num2)
                # print("계산 대상 :", num1, op, num2, "/ 현재 인덱스 :", idx)
                result.insert(idx - 1, eval(now_expression))
                idx -= 1
                # print(result)
            idx += 1

    # 절댓값으로 계산 하도록 제시되어 있었으므로
    return abs(int(result[0]))


# count = 1이면 그냥 그대로 반환
# count = 2면 + - / - +일 때
# count = 3이면 * + - / * - + / + * - / + - * / - + * / - * + 일 때
# 1 - 2 * 3 - 2 - 3 * 2 * 2 = - 2 * 3 - 3 * 2 * 2 - 2 + 1
def solution(expression):
    answer = []

    # operator_list = get_operator_list(expression)
    # operator_list = list(permutations(operator_list, len(operator_list)))

    # permutations : 리스트를 순열로 표시해준다. 양식은 permutations(리스트, 경우의수)
    operator_list = permutations(['+', '-', '*'], 3)

    splitted_expression = get_splitted_expression(expression)

    for ops in operator_list:
        answer.append(calc_by_splitted_expression_and_operator_list(splitted_expression, ops))

    # print(answer)
    return max(answer)


print(solution("100-200*300-500+20"))
