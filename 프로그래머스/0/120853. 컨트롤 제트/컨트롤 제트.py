def solution(s):
    stack=[]
    for i in (s.split()):
        if i =='Z':
            if stack:  # 스택이 비어있지 않을 경우에만 pop을 실행
                stack.pop()
        else:
            stack.append(int(i))
    return sum(stack)