def solution(babbling):
    cnt=0
    words = ["aya", "ye", "woo", "ma"]
    for bab in babbling:
        for word in words:
            bab = bab.replace(word, ' ')
        if not bab.strip():
            cnt+=1
    return cnt
            