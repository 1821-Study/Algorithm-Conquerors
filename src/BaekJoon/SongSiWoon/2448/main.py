import math

n = int(input())
n = int(math.log2(n//3) + 1)
width = 6 * (2**(n-1)) - 1
hieght = 3 * (2**(n-1))
stars = [[' '] * width for _ in range(hieght)]


def sol(n, r, c):
    if n == 1:
        stars[r][c+2] = '*'
        stars[r+1][c+1] = '*'
        stars[r+1][c+3] = '*'
        for i in range(5):
            stars[r+2][c+i] = '*'
        return

    length = 3 * (2**(n-2))

    sol(n-1, r + length, c)  # 왼쪽
    sol(n-1, r, c + length)  # 위
    sol(n-1, r + length, c + length * 2)  # 오른쪽


def printstar(stars):
    for star in stars:
        print(''.join(star))


sol(n, 0, 0)
printstar(stars)
