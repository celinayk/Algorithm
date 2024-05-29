def solution(sides):
    max_num=max(sides)
    min_num=min(sides)
    ans=0;
    for i in range(1, max_num+1):
        if i+min_num>max_num:
            ans+=1
    for i in range(max_num+1, min_num+max_num):
        ans+=1
    return ans