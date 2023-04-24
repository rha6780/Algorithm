import sys


if __name__ == "__main__":
    A,B,N = map(int, sys.stdin.readline().split())
    result = 0
    for i in range(N):
        A = (A%B)*10
        result = A//B
    print(result)