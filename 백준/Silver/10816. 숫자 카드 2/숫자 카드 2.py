import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline())
    cards = list(map(int, sys.stdin.readline().split()))
    M = int(sys.stdin.readline())
    questions = list(map(int, sys.stdin.readline().split()))
    counts = {}

    for i in cards:
        if i not in counts:
            counts[i] = 1
        else:
            counts[i] += 1

    for i in questions:
        if i in counts:
            print(counts[i], end=' ')
        else:
            print(0, end=' ')
