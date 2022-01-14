N = int(input())

width = 4*(N-1) + 1
hieght = 4*(N-1) + 3
star = [[' ']*width for _ in range(hieght)]


def sol(n, r, c):
    global width
    global hieght
    w = 4 * (n - 1) + 1
    h = 4 * (n - 1) + 3

    if n == 1:
        star[(hieght+1)//2-2][(width-1)//2] = "*"
        star[(hieght+1)//2-1][(width-1)//2] = "*"
        star[(hieght+1)//2][(width-1)//2] = "*"
        return

    else:
        # 위
        for i in range(w):
            star[r][c+i] = '*'
        # 왼쪽
        for i in range(h):
            star[r+i][c] = '*'
        # 아래
        for i in range(w):
            star[r+h-1][c+i] = '*'
        # 오른쪽
        for i in range(r+2, r+h):
            star[i][c+w-1] = '*'

        star[r+2][c+w-2] = '*'

    sol(n-1, r+2, c+2)


if N == 1:
    print("*")
else:
    sol(N, 0, 0)
    for s in star:
        print(''.join(s).rstrip())
