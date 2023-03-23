import sys
import math

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    costs = list(map(int, sys.stdin.readline().split()))

    payments = []
    payments.append(costs[0])
    if N == 1:
        print(costs[0])
    else:
        for i in range(2, N + 1):
            max = costs[i - 1]
            for j in range(1, i):
                comb = payments[j - 1] + payments[i - j - 1]
                if max < comb:
                    max = comb
            payments.append(max)
        print(payments[N - 1])
