n = 1000 - int(input())
count = 0
number = [500, 100, 50, 10, 5, 1]
for i in number:
    if n//i != 0:
        count += (n//i)
        n = n % i
print(count)
