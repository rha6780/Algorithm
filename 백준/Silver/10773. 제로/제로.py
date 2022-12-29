import sys

if __name__ == '__main__':
    K = int(sys.stdin.readline())
    nums = []
    for i in range(K):
        num = int(sys.stdin.readline())
        if num != 0:
            nums.append(num)
        else:
            nums.pop()

    print(sum(nums))
