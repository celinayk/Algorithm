import math

def solution(n):
    answer = 0
    n = math.sqrt(n)
    if not n.is_integer():
        return -1
    else:
        n=int(n)+1
        return n*n
