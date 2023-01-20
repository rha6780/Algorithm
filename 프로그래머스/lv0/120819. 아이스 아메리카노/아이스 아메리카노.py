def solution(money):
    answer = []
    answer.append(int(money/5_500))
    answer.append(int(money%5_500))
    return answer