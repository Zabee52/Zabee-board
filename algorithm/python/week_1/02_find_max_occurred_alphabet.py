input = "hello my name is sparta"


def find_max_occurred_alphabet(string):
    alpha_arr = [0] * 26

    for char in string:
        if char.isalpha():
            alpha_arr[ord(char) - ord('a')] += 1
    # 이 부분을 채워보세요!
    return alpha_arr


result = find_max_occurred_alphabet(input)
print(result)