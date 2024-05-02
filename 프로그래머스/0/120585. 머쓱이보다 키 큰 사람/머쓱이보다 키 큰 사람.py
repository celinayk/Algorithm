def solution(array, height):
    cnt=0
    for i in array:
        if height<i:
            cnt+=1
    return cnt