floor = int(input())
for i in range(1, floor+1):
    print(" "*(floor-i), end="")
    print("*"*(2*i-1))
for y in range(1, floor):
    print(" "*y, end="")
    print("*"*((floor-y)*2-1))