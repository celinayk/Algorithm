def solution(num, k):
    num = list(map(int, str(num)))  
    for i in num:
        if i == k:
            return num.index(i)+1
    return -1  