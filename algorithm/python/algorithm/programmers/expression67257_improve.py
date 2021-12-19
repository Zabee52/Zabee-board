# 개선 내용

# 42번 라인 : 계산식 굳이 operation으로 뽑아내서 계산할 필요 없이 eval로 해줬다.

# 52번 라인 : 연산자 세 개 다 쓰는것도 속도 차이가 얼마 크지 않았던걸 보니, 굳이 연산자의 종류를 따질 필요 없이,
# operator_list = permutations(['+', '-', '*'], 3)
# 으로 해줬다.

# solution 함수 : 맥스힙 적용해봤다.

from itertools import permutations
import heapq


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
    result = list(splitted_expression)
    for op in operator_list:
        idx = 0
        while idx < len(result):
            if result[idx] == op:
                # result[idx] == op : 현재 작업해야하는 연산자임. 연산하면 됨
                num1 = result.pop(idx - 1)
                result.pop(idx - 1)
                num2 = result.pop(idx - 1)
                now_expression = str(num1) + op + str(num2)
                result.insert(idx - 1, eval(now_expression))
                idx -= 1
            idx += 1

    # 절댓값으로 계산 하도록 제시되어 있었으므로
    return abs(int(result[0]))


def solution(expression):
    answer = []
    operator_list = permutations(['+', '-', '*'], 3)
    splitted_expression = get_splitted_expression(expression)

    for ops in operator_list:
        heapq.heappush(answer, calc_by_splitted_expression_and_operator_list(splitted_expression, ops) * -1)

    return heapq.heappop(answer) * -1


print(solution("100-200*300-500+20"))

