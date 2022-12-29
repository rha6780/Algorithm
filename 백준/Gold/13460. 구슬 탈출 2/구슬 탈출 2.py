from collections import deque
import sys


def BFS(rx, ry, bx, by):
    movex = [0, 0, -1, 1]
    movey = [-1, 1, 0, 0]
    count = 0
    que = deque()
    que.append((rx, ry, bx, by, 0))
    visited.append([rx, ry, bx, by])
    while que:
        rtx, rty, btx, bty, count = que.popleft()
        if count > 10:
            return -1
        for i in range(4):
            mrx, mry, mbx, mby = rtx, rty, btx, bty
            while True:
                mbx += movex[i]
                mby += movey[i]
                if fields[mbx][mby] == '#' or fields[mbx][mby] == 'O':
                    mbx -= movex[i]
                    mby -= movey[i]
                    break
            while True:
                mrx += movex[i]
                mry += movey[i]
                if fields[mrx][mry] == '#' or fields[mrx][mry] == 'O':
                    mrx -= movex[i]
                    mry -= movey[i]
                    break

            if fields[mbx+movex[i]][mby+movey[i]] == 'O':
                continue

            if fields[mrx+movex[i]][mry+movey[i]] == 'O':
                if count + 1 <= 10:
                    return count + 1
                else:
                    return -1

            if mbx == mrx and mby == mry:
                if abs(mrx - rtx) + abs(mry - rty) > abs(mbx - btx) + abs(mby - bty):
                    mrx -= movex[i]
                    mry -= movey[i]
                else:
                    mbx -= movex[i]
                    mby -= movey[i]

            if mrx == rtx and mry == rty and mbx == btx and mby == bty:
                continue

            que.append((mrx, mry, mbx, mby, count+1))

    return -1


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    fields = []
    rx, ry, bx, by = 0, 0, 0, 0
    visited = []
    for i in range(N):
        fields.append(list(map(str, sys.stdin.readline().rstrip())))

    for i in range(N):
        for j in range(M):
            if fields[i][j] == 'R':
                rx, ry = i, j
            elif fields[i][j] == 'B':
                bx, by = i, j
            if rx != 0 and ry != 0 and bx != 0 and by != 0:
                break

    result = BFS(rx, ry, bx, by)
    print(result)
