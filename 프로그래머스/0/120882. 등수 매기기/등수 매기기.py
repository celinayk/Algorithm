def solution(score):
    ans=[]
    for eng, math in score:
        ans.append((eng+math)/2)
    ans_s=sorted(ans, reverse=True)
    rank = [ans_s.index(i)+1 for i in ans]
    return rank