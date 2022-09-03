A=[]
B=[]

for i in range(0,10):
  A.append(int(input()))

for i in range(0,10):
  B.append(int(input()))

A.sort()
B.sort()
sum1=A[9]+A[8]+A[7]
sum2=B[9]+B[8]+B[7]

print(str(sum1)+" "+str(sum2))