input = "abafabaec"


def find_not_repeating_character(string):
    string_arr = [0] * 26
    repeating_arr = []

    for char in string:
        if char.isalpha():
            string_arr[ord(char) - ord('a')] += 1

    for index in range(len(string_arr)):
        if string_arr[index] == 1:
            repeating_arr.append(chr(index + ord('a')))

    for char in string:
        if char in repeating_arr:
            return char
    else:
        return "not found"


result = find_not_repeating_character(input)
print(result)