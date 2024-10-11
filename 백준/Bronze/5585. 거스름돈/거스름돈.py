import sys

N = int(sys.stdin.readline())
N=1000-N
arr= [500,100,50,10,5,1]

cnt=0
for i in arr:
    cnt+=N//i
    N%=i
print(cnt)