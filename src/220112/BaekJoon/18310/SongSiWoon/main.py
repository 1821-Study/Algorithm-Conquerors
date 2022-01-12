N = int(input())
home = list(map(int, input().split()))

home.sort()
res = home[(N-1)//2]
print(res)
