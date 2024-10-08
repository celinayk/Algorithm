def solution(x):
    str_x = str(x)
    sum = 0
    for i in str_x:
        sum+=int(i)
    if x % sum==0:
        return True
    else:
        return False
 