price = int(input())
coin = [500, 100, 50, 10, 5, 1]
cnt = 0
changes = 1000 - price

for c in coin:
    cnt += changes // c
    changes %= c

print(cnt)
