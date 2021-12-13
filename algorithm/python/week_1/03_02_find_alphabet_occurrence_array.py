def find_alphabet_occurrence_array(string):
    alpha_arr = [0] * 26

    for char in string:
        if char.isalpha():
            alpha_arr[ord(char) - ord('a')] += 1

    max_alpha_occurrence = 0
    max_alpha_idx = 0
    for index in range(len(alpha_arr)):
        if max_alpha_occurrence < alpha_arr[index]:
            max_alpha_occurrence = alpha_arr[index]
            max_alpha_idx = index

    return chr(max_alpha_idx + ord('a'))


print(find_alphabet_occurrence_array("hello my name is sparta"))