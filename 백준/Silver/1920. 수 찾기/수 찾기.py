N=int(input())
A=list(map(int, input().strip().split())) # 이렇게 하면 한줄에 배열을 입력받을수 있다.
M=int(input())
B=list(map(int, input().strip().split()))

A.sort()

for i in range(0, M):
  flag=0
  mid=0
  l=0
  r=N-1
  while l<=r:
    mid=int((l+r)/2)
    if A[mid]>B[i]:
      r=mid-1
    elif A[mid]<B[i]:
      l=mid+1
    else:
      flag=1
      break
  print(flag)