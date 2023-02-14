def solution(n, k):
    answer = (12000*n)+(2000*k)
    discount = int(n/10)
    answer -= (2000*discount)
    return answer