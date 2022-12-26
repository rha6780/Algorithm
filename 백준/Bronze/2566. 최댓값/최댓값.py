if __name__ == '__main__':
    nums = []
    point = []
    for i in range(9):
        l = list(map(int, input().split()))
        ml = max(l)
        nums.append(ml)
        point.append(l.index(ml))

    max = max(nums)
    print(max)
    ind = nums.index(max)
    print(ind+1, point[ind]+1)
