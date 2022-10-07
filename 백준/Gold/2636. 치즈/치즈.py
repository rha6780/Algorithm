from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

a, b=map(int, input().split())
cheeze=[[int(x) for x in input().split()]for _ in range(a)]

temp=0
def bfs(tmp):
    while queue:
        n=queue.popleft()
        for i in range(4):
            nx=n[0]+dx[i]
            ny=n[1]+dy[i]
            if 0<=nx<a and 0<=ny<b and visit[nx][ny]==0:
                visit[nx][ny]=1
                if cheeze[nx][ny]==1:
                    tmp-=1
                else: queue.append([nx, ny])
    return tmp



queue=deque()
cnt=0
answer=0

for i in range(a):
    for j in range(b):
        if cheeze[i][j]==1:
            answer+=1
temp=answer
while answer!=0:
    visit=[[0 for _ in range(b)] for _ in range(a)]
    queue.append([0,0])
    visit[0][0]=1
    answer=bfs(answer)
    if answer!=0:
        temp=answer
    cnt+=1

    for i in range(a):
        for j in range(b):
            if cheeze[i][j]==1 and visit[i][j]==1:
                cheeze[i][j]=0
                #print(i," ", j, "제거")


print(cnt)
if answer==0:
    answer=temp
print(answer)