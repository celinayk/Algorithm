def solution(array):
    cnt = [0] * (max(array) + 1)
    
    for i in array:
        cnt[i] += 1
    
    n=0
    for c in cnt:
        if c==max(cnt):
            n+=1
            
    if n>1:
        return -1
    else:
        return cnt.index(max(cnt))            
        
        