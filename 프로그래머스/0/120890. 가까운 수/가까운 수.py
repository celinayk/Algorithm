def solution(array, n):
    array.sort()
    ans =[]
    for i in array:
        num=abs(i-n)
        ans.append(num)
    return array[ans.index(min(ans))]
    