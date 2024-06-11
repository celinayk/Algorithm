import math
def solution(a, b):
    c=math.gcd(a,b)
    a=a//c
    b=b//c
    while b % 2 == 0:
        b //= 2
    while b % 5 == 0:
        b //= 5
    
    # 최종적으로 b가 1이 되면 유한소수, 그렇지 않으면 무한소수
    if b == 1:
        return 1
    else:
        return 2