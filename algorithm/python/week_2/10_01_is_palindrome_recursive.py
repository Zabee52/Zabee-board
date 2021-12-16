input = "abcba"


def is_palindrome_recursive(string):
    if len(string) <= 1:
        return True
    if string[0] != string[-1]:
        return False
    return is_palindrome_recursive(string[1:-1])


print(is_palindrome_recursive(input))