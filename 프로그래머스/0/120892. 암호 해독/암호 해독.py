def solution(cipher, code):
    ans=''
    for i in range(code-1, len(cipher), code):  
        ans += cipher[i] 
    return ans
       