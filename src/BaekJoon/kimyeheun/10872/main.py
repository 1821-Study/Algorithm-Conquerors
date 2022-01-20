a = int(input())
def fac(a):
    if a == 0:
        return 1
    else:
        return fac(a-1) * a
print(fac(a))
