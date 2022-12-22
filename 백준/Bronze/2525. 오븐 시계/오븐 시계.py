def calculate(h, m):
    h += int(m/60)
    h = int(h % 24)
    m = int(m % 60)
    print(str(h) + ' ' + str(m))


if __name__ == '__main__':
    h, m = map(int, input().split())
    time = int(input())
    m += time
    calculate(h, m)
