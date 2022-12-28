if __name__ == '__main__':
    N = int(input())
    positions = []
    for i in range(N):
        a, b = map(int, input().split())
        positions.append((a, b))
    positions.sort(key=lambda x: (x[1], x[0]))
    # print(positions)
    for i in range(N):
        print(positions[i][0], positions[i][1])
