def solution(age):
    ans=''
    alpha = 'abcdefghij'
    for i in str(age):
        ans+=alpha[int(i)]
    return ans
        
        