n,k=map(int, input().split())
person=list(map(int, input().split()))
distance=[]
for i in range(n-1):
    distance.append(person[i+1]-person[i])
distance.sort()
sum=0
for i in range(n-k):
    sum+=distance[i]
print(sum)