if __name__ == '__main__':
    a, b, c=map(int, input().split())
    if (c-b)==0:
        result=-1
    else:
        result=int(1+(a/(c-b)))
    if result<0: result=-1
    print(result)
