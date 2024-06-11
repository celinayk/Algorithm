def solution(polynomial):
    num=0
    m=0
    sum=0
    ssum=0
    polynomial=polynomial.replace(" ","")
    ll=polynomial.split("+")
    for i in ll:
        if 'x' in i:  
            m = i.replace("x", "")  
            if m == '':  
                m = 1  
            else:
                m = int(m)  
            sum += m 
        else: 
            ssum += int(i)
            
    
    if sum == 1:  # 계수가 1인 경우
        ss = 'x'
    elif sum==0:
        ss=''
    else:
        ss = str(sum) + 'x'  # 일반적인 경우
        
    if ssum != 0:
        if sum != 0:
            return ss + ' + ' + str(ssum)
        else:
            return str(ssum)
    else:
        return ss
            