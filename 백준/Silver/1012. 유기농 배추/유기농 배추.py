import bisect
import sys
import math
from collections import deque

sys.setrecursionlimit(10000)

T = int(sys.stdin.readline())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
    visited[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <=nx<M and 0<=ny<N:
            if not visited[nx][ny] and board[nx][ny] == 1:
                dfs(nx, ny)



# 1. 문제의 input을 받습니다.
for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    board = [[0 for _ in range(N)] for _ in range(M)]
    visited = [[False for _ in range(N)] for _ in range(M)]
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        board[x][y] = 1
    ans = 0
    for i in range(M):
        for j in range(N):
            if board[i][j] == 1 and not visited[i][j]:
                dfs(i,j)
                ans+=1
    print(ans)