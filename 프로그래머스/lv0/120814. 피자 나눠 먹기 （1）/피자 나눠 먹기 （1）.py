def solution(n):
    rest = int(n%7)
    answer = int(n/7)
    if rest > 0:
        answer += 1
    return answer