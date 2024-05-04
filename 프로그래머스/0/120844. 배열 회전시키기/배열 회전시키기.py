def solution(numbers, direction):
    n = len(numbers)
    if direction == 'right':
        tmp = numbers[-1]
        for i in range(n-1, 0, -1):
            numbers[i]=numbers[i-1]
        numbers[0]=tmp
    else:
        tmp = numbers[0]
        for i in range(n-1):
            numbers[i]=numbers[i+1]
        numbers[-1]=tmp
    return numbers