def lcm(a, b):
    for i in range(max(a, b), (a * b) + 1):
        if i % a == 0 and i % b == 0:
            return i
        
def solution(n):
    ans = 0
    ans = lcm(n,6)
    return ans//6