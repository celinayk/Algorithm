def solution(n):
    ans=0
    for i in range(1, 1000001):
        if n == i**2:
            ans=1
            break
        else:
            ans=2
    return ans
 
