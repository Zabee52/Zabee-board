input = "011110"


def find_count_to_turn_out_to_all_zero_or_all_one(string):
    zero_cnt = 0

    for char in string:
        if char == "0":
            zero_cnt += 1

    if len(string) - zero_cnt > zero_cnt:
        return zero_cnt
    else:
        return len(string) - zero_cnt


result = find_count_to_turn_out_to_all_zero_or_all_one(input)
print(result)