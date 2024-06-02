def solution(numlist, n):
    sorted_list = sorted(numlist, key=lambda x: (abs(x - n), -x))
    return sorted_list 
  