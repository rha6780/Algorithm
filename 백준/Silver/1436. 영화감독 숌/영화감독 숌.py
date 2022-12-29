if __name__ == '__main__':
    N = int(input())
    count = 0
    num = 666
    while (1):
        st_n = str(num)
        if st_n.find('666') != -1:
            count += 1
        if count == N:
            break
        num += 1

    print(num)
