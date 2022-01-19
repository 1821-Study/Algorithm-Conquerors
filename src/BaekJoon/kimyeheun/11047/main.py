n, k = map(int, input().split())
coin = []
count = 0
for i in range(n):
    coin.append(int(input()))
for u in range(len(coin)):
    if k//coin[-(u+1)] != 0:
        count += k//coin[-(u+1)]
        k %= coin[-(u+1)]
print(count)
