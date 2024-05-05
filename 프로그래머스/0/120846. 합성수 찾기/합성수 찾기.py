import math
def solution(n):
    cnt=0
    ans=[]
    for i in range(1, n+1):
        for j in range(1, i+1):
            if i%j==0:
                ans.append(i)
        if ans.count(i) >=3:
            cnt += 1
    return cnt