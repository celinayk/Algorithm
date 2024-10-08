def solution(price, money, count):
    sum=0
    for i in range(1, count+1):
        sum+=i*price
    if sum > money:
        return sum-money
    elif sum==money:
        return 0
    else:
        return 0
    
