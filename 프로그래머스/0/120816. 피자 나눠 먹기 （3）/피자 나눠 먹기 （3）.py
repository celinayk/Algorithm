def solution(slice, n):
    a=n//slice
    b=n%slice
    if b>1:
        b=1
    return a+b