
from audioop import add


if __name__ == '__main__':
    N, B = map(int, input().split())
    gifts = []
    for i in range(N):
        item = list(map(int, input().split()))
        gifts.append(item)

    gifts.sort(key=lambda x: (x[0], x[1]))
    max = 0
    # print(gifts)
    for i in range(N):
        costs = []
        for j in range(N):
            cost = 0
            if i == j:
                cost = (gifts[j][0]/2) + gifts[j][1]
            else:
                cost = gifts[j][0] + gifts[j][1]
            costs.append(cost)
        costs.sort()
        sum = 0
        p_count = 0
        for h in range(N):
            sum += costs[h]
            p_count += 1
            if sum > B:
                break
            else:
                if max < p_count:
                    max = p_count

    print(max)
