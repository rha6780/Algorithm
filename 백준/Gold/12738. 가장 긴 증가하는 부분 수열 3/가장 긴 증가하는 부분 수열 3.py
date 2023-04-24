from pickle import decode_long
import sys

def bs(left, right, i):
    while(left <= right):
        mid = (left+right)//2
        if lis[mid] < nums[i]:
            left = mid + 1
        else:
            right = mid-1
    return left



if __name__ == "__main__":
    N = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    cnt = 1
    lis = list( 0 for _ in range(N))
    lis[0] = nums[0]

    for i in range(N):
        if lis[cnt-1] < nums[i]:
            lis[cnt] = nums[i]
            cnt += 1
        else:
            left = 0
            right = cnt
            ind = bs(left, right, i)
            lis[ind] = nums[i]

    print(cnt)