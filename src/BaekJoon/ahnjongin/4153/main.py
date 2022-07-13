while True:
    a = list(map(int, input().split()))
    s_a = sorted(a)
    if(s_a[0] ==0):
        break
    if(s_a[0]**2 + s_a[1]**2 == s_a[2]**2):
        print("right")
    else:
        print("wrong")

