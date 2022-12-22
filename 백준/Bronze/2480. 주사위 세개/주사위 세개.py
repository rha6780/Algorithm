if __name__ == '__main__':
    dice = list(map(int, input().split()))
    result = 0
    for i in dice:
        count = dice.count(i)
        if count == 3:
            result = 10_000+(i*1_000)
        elif count == 2:
            result = 1_000+(i*100)
        if result > 0:
            break
    if result == 0:
        result = result = (max(dice)*100)
    print(result)
