if __name__ == '__main__':
  a=list(input() for _ in range(7))
  sum=0
  min1=1000000
  for i in a:
    if int(i)%2==1:
      sum+=int(i)
      min1=min(min1, int(i))
  if sum==0:
    print(-1)
  else:
    print(sum)
    print(min1)