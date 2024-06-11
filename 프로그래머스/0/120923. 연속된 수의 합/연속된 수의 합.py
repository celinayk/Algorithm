def solution(num, total):
    mid = total//num
    return [i for i in range(mid - (num-1)//2, mid + (num + 2)//2)]
    