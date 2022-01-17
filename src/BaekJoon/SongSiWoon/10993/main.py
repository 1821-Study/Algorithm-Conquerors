n = int(input())
width = (2 ** (n+1)) - 3
hieght = (2 ** n) - 1
stars = [[' '] * width for _ in range(hieght)]


def sol(n, r, c):
    w = (2 ** (n+1)) - 3
    h = (2 ** n) - 1
    if n == 1:
        stars[r][c] = '*'
        return

    if n % 2 == 0:
        stars[r][c] = '*'
        for i in range(h):
            stars[r-i][c-i] = '*'
            stars[r-i][c+i] = '*'
        for i in range(w):
            stars[r-(h-1)][c - (w-1)//2 + i] = '*'
        sol(n - 1, r-(h-2), c)

    else:
        stars[r][c] = '*'
        for i in range(h):
            stars[r + i][c - i] = '*'
            stars[r + i][c + i] = '*'
        for i in range(w):
            stars[r + (h - 1)][c - ((w - 1) // 2) + i] = '*'
        sol(n - 1, r + (h-2), c)


def printstar(stars):
    for star in stars:
        print(''.join(star))


if n % 2 == 0:
    sol(n, hieght - 1, width//2)
    for i in range(1, hieght):
        for _ in range(i):
            stars[i].pop()
else:
    sol(n, 0, width // 2)
    for i in range(1, hieght):
        for _ in range(i):
            stars[hieght-1-i].pop()

printstar(stars)
