def solution(arr):
    answer = []
    num= min(arr)
    arr.remove(num)
    if not arr:
        arr.append(-1)       
    return arr