import sys

if __name__ == '__main__':
    strings = sys.stdin.readline()
    nums = []
    strings = strings.replace('+', ' ').replace('-', ' -')
    nums = list(strings.split())
    sum = 0
    negative = 0
    for i in nums:
        num = int(i)
        if num < 0:
            negative = 1
            sum += num
        else:
            if negative == 1:
                sum -= num
            else:
                sum += num

    print(sum)
