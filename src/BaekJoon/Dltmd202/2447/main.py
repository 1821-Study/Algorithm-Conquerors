import math

n = int(input())

k = int(math.log10(n) / math.log10(3))
graph = [[' '] * (n + 1) for _ in range(n + 1)]


def makeMap(y, x, step):
    if step == 0:
        graph[y][x] = '*'
        return
    else:
        grid = 3 ** (step - 1)
        for i in range(3):
            makeMap(y, x - i * grid, step - 1)
            makeMap(y - 2 * grid, x - i * grid, step - 1)
        makeMap(y - grid, x, step - 1)
        makeMap(y - grid, x - 2 * grid, step - 1)


makeMap(n, n, k)

for g in graph[1:]:
    print(" ".join(g[1:]))

