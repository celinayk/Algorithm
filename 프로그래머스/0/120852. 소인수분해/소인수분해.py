def solution(n):
    answer = []
    ans=[]
    i=2
    while i<=n:
        if n%i ==0:
            answer.append(i)
            n = n/i
        else:
            i = i+1
    for i in answer:
        if i not in ans:
            ans.append(i)
    return ans