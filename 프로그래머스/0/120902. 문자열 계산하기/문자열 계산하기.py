def solution(my_string):
    tmp=my_string.split()
    ans = 0
    ans+=int(tmp[0])
    for i in range(1,len(tmp)+1):
        if i != len(tmp):
            if tmp[i]=='+':
                ans+=int(tmp[i+1])
            elif tmp[i]=='-':
                ans-=int(tmp[i+1])
            else:
                continue
    return ans
            
            
            
            
    return answer