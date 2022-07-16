testcase = int(input())
for _ in range(testcase):
    H, W, N = map(int, input().split())
    room = N // H + 1
    floor = N % H
    if N % H == 0:
        room = N // H
        floor = H
    print(floor*100 + room)