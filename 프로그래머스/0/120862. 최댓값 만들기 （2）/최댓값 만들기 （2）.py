def solution(numbers):
    numbers.sort(reverse=True)
    a=numbers[0]*numbers[1]
    b=numbers[-1]*numbers[-2]
    if a>b:
        return a
    else:
        return b