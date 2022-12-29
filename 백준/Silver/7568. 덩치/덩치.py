if __name__ == '__main__':
    N = int(input())
    nums = []
    for i in range(N):
        a, b = map(int, input().split())
        nums.append((a, b))

    grade = []
    for i in range(N):
        grade.append(0)
        for j in range(N):
            if nums[i][0] < nums[j][0] and nums[i][1] < nums[j][1]:
                grade[i] += 1

    grades = sorted(grade)
    grades = list(grades)
    result = ''
    for i in grade:
        result += str(i+1) + ' '
    print(result)
