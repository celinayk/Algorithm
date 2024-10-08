def solution(s):
    num = len(s)
    if num%2==0:
        return s[num//2 - 1:num//2 + 1]
    else:
        return s[num//2] 
        