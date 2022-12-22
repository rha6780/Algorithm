if __name__ == '__main__':
    N, M = map(int, input().split())
    n_group = []
    m_group = []
    result = 0
    for i in range(N):
        n_group.append(input())
    for j in range(M):
        m_group.append(input())
    for i in range(N):
        result += m_group.count(n_group[i])
    print(result)
