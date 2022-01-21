n,m=map(int, input().split())
list=[]
def per():
    if len(list)==m:
        print(' '.join(map(str,list)))
        return
    for i in range(1, n+1):
        if i in list:
            continue
        list.append(i)
        per()
        list.pop()
per()

