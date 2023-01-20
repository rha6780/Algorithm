def solution(n):
    x = 1
    answer = 0
    while(1):
        pizza = 6*x
        if pizza < n:
            x += 1
        else:
            if int(pizza%n) == 0:
                answer = x
                break
            else:
                x += 1
        
    return answer