def solution(my_string):
    num = '1234567890'
    total = 0
    for i in my_string:
        if i in num:
            total += int(i)
    return total
        
        