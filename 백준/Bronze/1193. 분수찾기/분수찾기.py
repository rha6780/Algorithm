#B1193
if __name__ == '__main__':
  a=int(input())
  count=1
  while True:
    if a>count:
      a-=count
      count+=1
    else:
      break
  mo=0
  so=0
  if count%2==0:
    mo=a
  else:
    mo=count+1-a
  so=count+1-mo
  st=str(mo)+"/"+str(so)
  print(st)