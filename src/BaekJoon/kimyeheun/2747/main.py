n = int(input())
fibo = [0, 1]
i = 2
while i <= n:
    fibo.append(fibo[-1]+fibo[-2])
    i += 1
print(fibo[n])
