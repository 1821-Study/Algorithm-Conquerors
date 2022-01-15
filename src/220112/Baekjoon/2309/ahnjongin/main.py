L=[]
a=0
b=0
for i in range(9):
    L.append(int(input()))
S=sum(L)
for i in range(0,8):
    for j in range(i+1,9):
        if S-(L[i]+L[j])==100:
            a=L[i]
            b=L[j]
L.remove(a)
L.remove(b)
L.sort()
for i in L:
    print(i)