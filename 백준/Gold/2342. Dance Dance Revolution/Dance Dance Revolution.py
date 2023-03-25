import sys


def move_step(step, next_step, power):
    move = abs(int(next_step - step))
    npower = power
    if step == 0:
        npower += 2
    else:
        if move == 0:
            npower += 1
        elif move == 2:
            npower += 4
        else:
            npower += 3
    return npower


if __name__ == "__main__":
    nums = list(map(int, sys.stdin.readline().split()))

    steps = {(0, 0): 0}
    count = len(nums) - 1
    for i in range(count):
        nstep = {}
        next_step = nums[i]
        for step in steps:
            left, right = step
            power = steps[step]
            npower = move_step(left, next_step, power)
            if npower < nstep.get((next_step, right), sys.maxsize):
                nstep[(next_step, right)] = npower

            npower = move_step(right, next_step, power)
            if npower < nstep.get((left, next_step), sys.maxsize):
                nstep[(left, next_step)] = npower
        steps = nstep
        
    min = sys.maxsize
    for j in steps:
        if min > steps[j]:
            min = steps[j]

    print(min)
