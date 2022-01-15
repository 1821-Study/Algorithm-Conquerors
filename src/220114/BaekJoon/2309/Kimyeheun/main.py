list=[]
for i in range(9):
    list.append(int(input()))
sum_=sum(list)
list.sort()
for y in range(9):
    for j in range(y+1,9):
        if (sum_-list[y]-list[j]==100):
            for e in range(9):
                if (e==y or e==j):
                    continue
                else:
                    print(list[e])
            exit()