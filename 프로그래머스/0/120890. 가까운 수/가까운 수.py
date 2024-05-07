def solution(array, n):
    ans =[]
    for i in array:
        num=abs(i-n)
        ans.append(num)
    min_diff=min(ans)
    closest_nums = [array[i] for i in range(len(array)) if ans[i] == min_diff] 
    return min(closest_nums)  
    #return array[ans.index(min(ans))]
    