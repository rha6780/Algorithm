import sys


def win_card(target):
    left = 0
    right = len(cards) - 1
    while left < right:
        mid = int((left + right) / 2)
        if cards[mid] > target:
            right = mid
        else:
            left = mid + 1

    return right


def find(a):
    if groups[a] == a:
        return a

    b = find(groups[a])
    groups[a] = b
    return b


def union(a, b):
    if b < M:
        a = find(a)
        b = find(b)
        groups[a] = b


if __name__ == "__main__":
    N, M, K = map(int, sys.stdin.readline().split())
    cards = list(map(int, sys.stdin.readline().split()))
    magician = list(map(int, sys.stdin.readline().split()))
    cards.sort()
    groups = [i for i in range(M)]

    for i in magician:
        c = win_card(i)
        index = find(c)
        print(cards[index])
        union(index, index + 1)
