import sys

if __name__ == '__main__':
    S = sys.stdin.readline()
    results = ''
    for i in S:
        if i >= 'a' and i <= 'z':
            ch = chr((ord(i)+13))
            if (ord(i)+13) > ord('z'):
                ch = chr((ord(i)+13) % ord('z') + 96)
            results += ch
        elif i >= 'A' and i <= 'Z':
            ch = chr((ord(i)+13))
            if (ord(i)+13) > ord('Z'):
                ch = chr((ord(i)+13) % ord('Z') + 64)
            results += ch
        else:
            results += i
    print(results)
