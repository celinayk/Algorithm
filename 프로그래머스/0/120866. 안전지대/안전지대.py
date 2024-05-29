def solution(board):
    n = len(board)
    for y, row in enumerate(board):
        for x, area in enumerate(row):
            if area == 1:
                for dy in [-1, 0, 1]:
                    for dx in [-1, 0, 1]:
                        ny = y + dy
                        nx = x + dx
                        
                        if 0 <= ny < n and 0 <= nx < n and board[ny][nx] != 1:
                            board[ny][nx] = "X"

    safe_area_count = sum([area.count(0) for area in board])
    return safe_area_count
