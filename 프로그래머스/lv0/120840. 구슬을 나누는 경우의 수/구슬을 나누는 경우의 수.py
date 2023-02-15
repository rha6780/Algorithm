def solution(balls, share):
    answer = 0
    top = 1
    bottom = 1
    for j in range(1, share+1):
        top *= balls
        bottom *= j
        balls -= 1
    answer = int(top/bottom)
    return answer