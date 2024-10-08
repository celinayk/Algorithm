def solution(s):
    answer = False
    s = s.lower();
    if s.count("p") ==  s.count("y"):
        return True
    else:
        return False

