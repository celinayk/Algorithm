import bisect
import sys
import math
from collections import deque

T = int(sys.stdin.readline())


def dfs(node):
    visited[node] = True
    next = arr[node]
    if not visited[next]:
        dfs(next)


for _ in range(T):
    # 1. 문제의 input을 받습니다.
    N = int(sys.stdin.readline())
    arr = [0] + list(map(int, sys.stdin.readline().split()))

    # 2. 탐색을 위한 배열을 초기화 합니다.
    visited = [False for _ in range(N + 1)]

    ans = 0
    for i in range(1, N+1):
        if not visited[i]:
            dfs(i)
            ans+=1

    print(ans)