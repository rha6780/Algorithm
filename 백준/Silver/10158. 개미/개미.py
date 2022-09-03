w, h=map(int, input().split())
p, q=map(int, input().split())
t=int(input())

pp=(t+p)%(2*w)
qq=(t+q)%(2*h)

x=0
y=0
if (pp//w)==1:
  x=w-(pp%w)
else:
  x=pp%w

if (qq//h)==1:
  y=h-(qq%h)
else:
  y=qq%h

print(str(x)+" "+str(y))