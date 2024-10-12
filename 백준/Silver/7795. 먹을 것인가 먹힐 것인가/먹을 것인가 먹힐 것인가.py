import bisect
import sys

T = int(sys.stdin.readline())

for _ in range(T):
    A, B = map(int, sys.stdin.readline().split())
    arr_a = list(map(int, sys.stdin.readline().split()))
    arr_b = list(map(int, sys.stdin.readline().split()))

    arr_b.sort()
    answer=0
    for i in arr_a:
        left = bisect.bisect_left(arr_b, i)
        answer+=left
    print(answer)




