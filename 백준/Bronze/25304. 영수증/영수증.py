if __name__ == '__main__':
    total = int(input())
    item_count = int(input())
    for i in range(item_count):
        cost, count = map(int, input().split())
        total -= cost*count
    if total == 0:
        print('Yes')
    else:
        print('No')
