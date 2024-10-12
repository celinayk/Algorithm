import bisect
import sys
import math
from collections import deque

sys.setrecursionlimit(10 ** 6)

# 1. 문제의 input을 받습니다.
N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# 2. 탐색을 위한 배열을 초기화 합니다.
visited = [False for _ in range(N + 1)]


def dfs(node):
    visited[node] = True
    for x in graph[node]:
        if not visited[x]:
            dfs(x)
ans=0
for i in range(1, N+1):
    if not visited[i]:
        dfs(i)
        ans+=1
print(ans)