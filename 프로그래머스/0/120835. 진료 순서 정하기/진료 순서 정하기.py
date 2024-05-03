def solution(emergency):
    ans = []
    tmp = []
    
    tmp = sorted(emergency)
    tmp.reverse()
    
    for i in emergency:
        ans.append(tmp.index(i)+1)
    return ans
    