def solution(n):
    n= str(n)
    n = ''.join(sorted(n,reverse=True))
    return int(n)
    
