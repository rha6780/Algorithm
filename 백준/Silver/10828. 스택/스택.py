import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline())
    stack = []
    for i in range(N):
        strings = list(map(str, sys.stdin.readline().split()))
        if strings[0] == 'push':
            stack.append(int(strings[1]))
        elif strings[0] == 'top':
            if len(stack) == 0:
                print(-1)
            else:
                print(stack[-1])
        elif strings[0] == 'pop':
            if len(stack) == 0:
                print(-1)
            else:
                print(stack.pop())
        elif strings[0] == 'size':
            print(len(stack))
        elif strings[0] == 'empty':
            if len(stack) == 0:
                print(1)
            else:
                print(0)
