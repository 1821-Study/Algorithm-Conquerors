n = int(input())
count = 0

while n >= 0:
    if n%3 == 0:
        count += n//3
        print(count)
        break
    n -= 5
    count += 1
else:
    print(-1)