num, maxi = map(int, input().split())
card = list(map(int, input().split()))
check=[]
for i in range(len(card)-2):
    for u in range(i+1, len(card)-1):
        for y in range(u+1, len(card)):
            total = card[i] + card[u] + card[y]
            if total <= maxi:
                check.append(total)
check.sort()
print(check[-1])
