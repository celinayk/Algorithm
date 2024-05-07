def solution(array):
    ans=[]
    ans.append(max(array))
    ans.append(array.index(max(array)))
    return ans