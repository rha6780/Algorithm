from copy import deepcopy
import sys



def BFS(dic):
    cnt = 0
    changed = 0
    filed = deepcopy(rooms)
    # print(filed)
    que = list()
    for virx, viry in dic[cnt]:
        filed[virx][viry] = 1
    que.append(dic)
    while len(que) != 0:
        if changed == empty:
            break
        points = que.pop()
        tmp = {cnt+1: []}
        for x, y in points[cnt]:
            for i in range(4):
                mx = x+movex[i]
                my = y+movey[i]
                if mx >=0 and mx < N and my >=0 and my < N :
                    if filed[mx][my] == 0:
                        tmp[cnt+1].append((mx,my))
                        filed[mx][my] = 1
                        changed += 1
                    if filed[mx][my] == 2:
                        tmp[cnt+1].append((mx,my))
                        filed[mx][my] = 1

        if tmp[cnt+1] == []:
            break
        que.append(tmp)
        # print(tmp)
        cnt += 1
    if changed == empty:
        # print(changed, empty)
        # print(cnt)
        return cnt
    else:
        return 20_000


def comb(arr, depth):
    t = []
    if depth == 0 :
        return [[]]
    for i in range(len(arr)):
        start = arr[i]
        for rest in comb(arr[i+1:], depth-1):
            t.append([start]+rest)
    return t


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    movex = [0,0,-1,1]
    movey = [-1,1,0,0]
    rooms = list()
    able_points = []
    count = 0
    result = 20_000
    empty = 0
    for i in range(N):
        row = list(map(int, sys.stdin.readline().split()))
        rooms.append(row)
        for j in range(N):
            if row[j] == 2:
                able_points.append([i, j])
                count += 1
            if row[j] == 0:
                empty += 1

    # print(empty)
    able = comb(able_points, M)
    
    for ap in able:
        # print(ap)
        dic = {0: [(x,y) for x, y in ap]}
        sec = BFS(dic)
        if sec != 20_000 and result > sec:
            result = sec
    
    # BFS(0,0, 1,1, 2,2)
    if result == 20_000:
        print(-1)
    else:
        print(result)

