T=int(input())
for t in range(0,T):
  num=[]
  for i in range(0,10):
    num.append(0)
  x=input()
  for j in range(0,len(x)):
    num[int(x[j:j+1])]+=1
  count=0
  for h in range(0,10):
    if num[h]>0:
      count+=1
  print(count)