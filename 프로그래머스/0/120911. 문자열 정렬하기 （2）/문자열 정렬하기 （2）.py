def solution(my_string):
    ans=''
    new=sorted(my_string.lower())
    for i in range(len(new)):
        ans+=new[i]
    return ans
    