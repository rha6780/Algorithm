while True:
  a, b, c= map(int, input().split())
  if a==0 and b==0 and c==0:
    break;
  else:
    if (a+c)/2==b:
      print("AP "+str(c*2-b))
    else:
      print("GP "+str(int(c*c/b)))