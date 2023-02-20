def solution(num_list, n):
    answer = []
    l = []
    count = 0
    for i in num_list:
        l.append(i)
        count += 1
        if count == n:
            answer.append(l)
            count = 0
            l = []
        
    return answer