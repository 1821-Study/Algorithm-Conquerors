n = int(input())
list=[0,1,]
for i in range(2,n+1):
    sum=list[i-1]+list[i-2]
    list.append(sum)
print(list[n])