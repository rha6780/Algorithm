from collections import deque
import queue


def bfs(graph, sx, sy, visited):
    movex = [0, 0, -1, 1]
    movey = [-1, 1, 0, 0]
    queue = deque()
    queue.append((sx, sy))
    visited[sx][sy] = 1
    count = 1
    while queue:
        vx, vy = queue.popleft()
        for i in range(4):
            tx = vx+movex[i]
            ty = vy+movey[i]
            if N > tx >= 0 and M > ty >= 0 and visited[tx][ty] != 1:
                if graph[vx][vy] == graph[tx][ty]:
                    count += 1
                    queue.append((tx, ty))
                    visited[tx][ty] = 1
    return count


if __name__ == '__main__':
    W_COUNT = 0
    B_COUNT = 0
    M, N = map(int, input().split())
    fields = []
    visited = [[0]*M for _ in range(N)]
    for i in range(N):
        fields.append(str(input()))

    for i in range(N):
        for j in range(M):
            if visited[i][j] != 1:
                c = bfs(fields, i, j, visited)
                # print(i, j, c**2)
                if fields[i][j] == 'W':
                    W_COUNT += (c**2)
                else:
                    B_COUNT += (c**2)

    print(W_COUNT)
    print(B_COUNT)
