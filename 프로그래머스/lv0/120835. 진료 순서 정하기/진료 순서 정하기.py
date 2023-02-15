def solution(emergency):
    answer = []
    sort_list = sorted(emergency)[::-1]
    for i in emergency:
        answer.append(sort_list.index(i)+1)
    return answer