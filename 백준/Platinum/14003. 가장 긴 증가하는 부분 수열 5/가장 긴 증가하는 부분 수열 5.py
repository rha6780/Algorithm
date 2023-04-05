import sys
import bisect as bs

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    lis = [-float("inf")]
    result = list(0 for _ in range(N))
    count = 1

    lis[0] = nums[0]
    lis[count-1] = lis[0]

    for i in range(N):
        if lis[-1] < nums[i]:
            result[i] = count
            lis.append(nums[i])
            count+=1

        else:
            left = bs.bisect_left(lis, nums[i])
            lis[left] = nums[i] # 여기
            result[i] = left

    answer = [0] * count
    print(count)
    for i in range(N-1, -1, -1):
        if result[i] == count-1:
            answer[count-1] = nums[i]
            count -= 1

    print(*answer)
    