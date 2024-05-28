def solution(keyinput, board):
    x, y = 0, 0
    max_x, max_y = board[0] // 2, board[1] // 2

    for key in keyinput:
        if key == "up" and y < max_y:
            y += 1
        elif key == "down" and y > -max_y:
            y -= 1
        elif key == "left" and x > -max_x:
            x -= 1
        elif key == "right" and x < max_x:
            x += 1

    return [x, y]