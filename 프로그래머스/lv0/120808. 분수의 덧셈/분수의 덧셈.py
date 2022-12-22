def solution(denum1, num1, denum2, num2):
    num = lcm(num1, num2)
    denum = (denum1*int(num/num1))+(denum2*int(num/num2))
    g_cd = gcd(num, denum)
    answer = [int(denum/g_cd), int(num/g_cd)]
    return answer


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)
    
def lcm(a, b):
    return int(a*b / gcd(a, b))
    