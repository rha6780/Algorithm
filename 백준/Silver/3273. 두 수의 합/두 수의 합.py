import sys

if __name__ == '__main__':
    N = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    X = int(sys.stdin.readline())
    start = 0
    end = N-1
    count = 0
    nums = sorted(nums)
    while start < end:
        sums = nums[start] + nums[end]
        if sums == X:
            count += 1
            start += 1
            end -= 1
        else:
            if sums < X:
                start += 1
            else:
                end -= 1

    print(count)
