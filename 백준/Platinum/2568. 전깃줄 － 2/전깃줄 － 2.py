import sys


def bs(left, right, value):
    while(left <= right):
        mid = (left+right)//2
        if lis[mid] < value:
            left = mid + 1
        else:
            right = mid-1
    return left



if __name__ == "__main__":
    N = int(sys.stdin.readline())
    elec = dict()
    keys = list()
    for i in range(N):
        a,b = map(int, sys.stdin.readline().split())
        keys.append(a)
        elec[a] = b

    cnt = 1
        
    keys.sort()
    lis = list(0 for _ in range(N))
    group = dict()
    lis[0] = elec[keys[0]]

    for key in keys:
        value = elec[key]
        if lis[cnt-1] < value:
            # print(key, ":", lis[cnt-1], "<", value)
            lis[cnt] = value
            group[cnt] = group[cnt-1][:]
            group[cnt].append(key)
            # print(cnt, lis[cnt])
            cnt += 1
        else:
            # print(key, ":", lis[cnt-1], ">=", value)
            left = 0
            right = cnt
            ind = bs(left, right, value)
            lis[ind] = value
            if ind > 0:
                group[ind] = group[ind-1][:]
                group[ind].append(key)
            else:
                group[ind] = [key]
            # print(ind, lis[ind], cnt)
            
            


    print(N-cnt)

    for k in keys:
        if k not in group[cnt-1][:]:
            print(k)
    
