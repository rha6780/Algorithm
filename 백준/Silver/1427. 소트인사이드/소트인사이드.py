if __name__ == '__main__':
    N = int(input())
    nums = str(N)
    nums = ''.join(sorted(nums, reverse=True))
    print(nums)
