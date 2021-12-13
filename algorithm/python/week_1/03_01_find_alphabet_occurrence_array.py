def find_alphabet_occurrence_array(string):
    alphabet_occurrence_array = [0] * 26

    max_occurrence = alphabet_occurrence_array[0]
    max_alpha = alphabet_occurrence_array[0]

    for char in string:

        if char.isalpha():
            index = ord(char) - ord('a')
            alphabet_occurrence_array[index] += 1

            if alphabet_occurrence_array[index] > max_occurrence:
                max_alpha = char
                max_occurrence = alphabet_occurrence_array[index]

    # 이 부분을 채워보세요!

    return max_alpha


print(find_alphabet_occurrence_array("hello my name is sparta"))