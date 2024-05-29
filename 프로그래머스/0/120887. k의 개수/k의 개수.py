def solution(i, j, k):
    cnt=0
    str0=''.join([str(num) for num in range(i, j+1)])
    return list(str0).count(str(k))
    
    