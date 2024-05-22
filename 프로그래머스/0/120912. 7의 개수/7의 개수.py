def solution(array):
    array = map(str, array)
    combined_str = "".join(array)
    return combined_str.count('7')