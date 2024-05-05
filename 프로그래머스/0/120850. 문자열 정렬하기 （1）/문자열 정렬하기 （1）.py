def solution(my_string):
    ans=[]
    for i in my_string:
        if i.isdigit():
             ans.append(int(i)) 
    return sorted(ans)