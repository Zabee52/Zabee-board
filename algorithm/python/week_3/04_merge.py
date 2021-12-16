array_a = [1, 2, 3, 5]
array_b = [4, 6, 7, 8]


def merge(array1, array2):
    array1_pointer = 0
    array2_pointer = 0
    result = []
    while array1_pointer < len(array1) and array2_pointer < len(array2):
        if array1[array1_pointer] < array2[array2_pointer]:
            result.append(array1[array1_pointer])
            array1_pointer += 1
        else:
            result.append(array2[array2_pointer])
            array2_pointer += 1
    if array1_pointer == len(array1):
        while array2_pointer < len(array2):
            result.append(array2[array2_pointer])
            array2_pointer += 1
    elif array2_pointer == len(array2):
        while array1_pointer < len(array1):
            result.append(array1[array1_pointer])
            array1_pointer += 1

    return result


print(merge(array_a, array_b))  # [1, 2, 3, 4, 5, 6, 7, 8] 가 되어야 합니다!