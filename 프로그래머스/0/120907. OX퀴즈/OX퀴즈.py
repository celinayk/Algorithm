def solution(quiz):
    ans = []
    for q in quiz:
        a,b = q.split("=")
        l,op,r = a.split()
        if op=='+':
            result = int(l) + int(r)
        else:
            result = int(l) - int(r)
        if result == int(b):
            ans.append("O")
        else:
            ans.append("X")
    return ans
    