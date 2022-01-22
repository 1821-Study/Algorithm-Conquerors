n = int(input())
check = []
count = 0
for i in range(0, 2000):
    for u in range(0, 1010):
        if n-(3*i + 5*u) == 0:
            check.append(i+u)
            count += 1
if count == 0:
    print(-1)
else:
    minni = check[0]
    for y in range(1, len(check)):
        if minni > check[y]:
            minni = check[y]
    print(minni)
