n,k=map(int, input().split())
coin_list=[int(input()) for i in range(n)]
coin_list.sort(reverse=True)
count=0
for i in coin_list:
    count+=k//i
    k%=i
print(count)