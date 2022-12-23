def possible(a, b):
    for p in range(1, b):
        if a+p == b-p:
            return (a+p)


if __name__ == '__main__':
    G = int(input())
    divisor = []
    for i in range(1, G+1):
        if int(G % i) == 0:
            result = possible(i, int(G/i))
            if result != None:
                divisor.append(result)

    for j in sorted(divisor):
        print(j)

    if len(divisor) == 0:
        print(-1)
