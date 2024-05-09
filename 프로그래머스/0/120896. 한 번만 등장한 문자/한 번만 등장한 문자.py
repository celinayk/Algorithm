def solution(s):
    ans=[]
    for i in s:
        if s.count(i)==1:
            ans.append(i)
    return ''.join(sorted(ans))