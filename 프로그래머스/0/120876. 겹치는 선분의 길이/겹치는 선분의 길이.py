def solution(lines):
    ans=0
    linelist=[]
    for line in lines:
        linelist+=line
    mn, mx = min(linelist), max(linelist)
    x,y,z=lines
    for i in range(mn, mx+1):
        cnt=0
        if x[0] <= i < x[1]:
            cnt+=1
        if y[0] <= i < y[1]:
            cnt+=1
        if z[0] <= i < z[1]:
            cnt+=1
        if cnt>=2:
            ans+=1
    return ans
        
    

        