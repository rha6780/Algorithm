plate=input()
put=[]
sum=10
for i in range(0,len(plate)):
  put.append(plate[i:i+1])

for i in range(1,len(plate)):
  if put[i]==put[i-1]:
    sum+=5
  else:
    sum+=10

print(sum)