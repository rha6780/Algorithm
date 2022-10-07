F=[]

N=int(input())
for i in range(0,N+1):
  if i==0:
    F.append(0)
  elif i==1:
    F.append(1)
  else:
    F.append(F[i-1]+F[i-2])

print(F[N])