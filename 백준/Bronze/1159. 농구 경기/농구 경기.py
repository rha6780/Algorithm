word=[]
name=[]

for j in range(0,26):
  word.append(0)

N=int(input())

for i in range(0, N):
  name.append(str(input()))
  word[int(ord(name[i][0])-ord('a'))]+=1

empt=True
for j in range(0,26):
  if word[j]>4:
    print(chr(ord('a')+j), end='')
    empt=False
if empt==True:
  print("PREDAJA")