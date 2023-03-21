if __name__ == "__main__":
    N = int(input())
    a1 = 1
    a2 = 2
    if N < 3:
        print(N)
    else:
        before = ()
        for i in range(3, N + 1):
            if i == 3:
                before = (a1, a2)
            else:
                before = (before[1], (before[0] + before[1]) % 15746)
        print((before[0] + before[1]) % 15746)
