def solution(age):
    answer = ''
    for i in str(age):
        answer += chr(ord('a')+int(i))
    return answer