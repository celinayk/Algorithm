def solution(num_list):
    ant=0
    bnt=0
    for i in num_list:
        if i%2==0:
            ant+=1
        else:
            bnt+=1
    return [ant, bnt]