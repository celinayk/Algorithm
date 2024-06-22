def solution(my_string):
    operator="+,-"
    ans=0
    op=''
    for i in my_string.split():
        if i in operator:
            op = i
        else:
            if op=='+':
                ans+=int(i)
            elif op=='-':
                ans-=int(i)
            else:
                ans=int(i)
    return ans
        