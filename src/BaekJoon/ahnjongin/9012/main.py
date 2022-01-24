testcase=int(input())
list_ = []
for i in range(testcase):
    count = 0
    list_ = input()
    for j in list_:
        if j == '(':
            count += 1
        elif j == ')':
            count -= 1
        if count < 0:
            print("NO")
            break
    if count == 0:
        print("YES")
    elif count > 0:
        print("NO")
