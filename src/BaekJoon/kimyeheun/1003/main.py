n_0 = [1, 0, 1]
n_1 = [0, 1, 1]


def fibo(n):
    if len(n_0) <= n:
        for y in range(len(n_0), test + 1):
            n_0.append(n_0[y - 1] + n_0[y - 2])
            n_1.append(n_1[y - 1] + n_1[y - 2])
    print(n_0[n], n_1[n])


case = int(input())

for i in range(case):
    test = int(input())
    fibo(test)
