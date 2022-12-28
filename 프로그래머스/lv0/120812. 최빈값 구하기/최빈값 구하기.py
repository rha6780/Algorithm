def solution(array):
    max_count = 0
    max_value = 0
    for a in array:
        counting = array.count(a)
        if counting == max_count:
            if max_value != a:
                flag = 1
        elif counting > max_count:
            max_value = a
            max_count = counting
            flag = 0
        
    answer = max_value
    if flag == 1:
        answer = -1
    return answer