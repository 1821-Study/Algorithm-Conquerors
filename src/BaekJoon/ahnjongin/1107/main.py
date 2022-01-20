n=int(input())
m=int(input())
if m>0:
    broken_button=set(input().split())
else:
    broken_button=set()
ans=abs(n-100)
for i in range(1000001):
    i=str(i)
    for j in range(len(i)):
        if i[j] in broken_button:
            break
        elif j == len(i)-1:
            ans=min(ans, abs(n-int(i))+len(str(i)))
print(ans)