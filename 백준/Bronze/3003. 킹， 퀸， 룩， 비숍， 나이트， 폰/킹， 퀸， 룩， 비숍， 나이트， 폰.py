if __name__ == '__main__':
    chess = [1, 1, 2, 2, 2, 8]
    chess_list = list(map(int, input().split()))
    result = ''
    for i in range(0, 6):
        result += str(chess[i]-chess_list[i]) + ' '
    print(result)
