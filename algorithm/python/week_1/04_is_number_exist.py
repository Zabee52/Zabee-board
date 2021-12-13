input = [3, 5, 6, 1, 2, 4]


def is_number_exist(number, array):
    result = False
    for num in array:
        if num == number:
            result = True
            break
    return result


result = is_number_exist(3, input)
print(result)