goal_ch = int(input())
broken = int(input())
to_ch = []
ch = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

def is_there(num):
    num= str(num)
    count=0
    for u in range(len(num)):
        for y in range(len(ch)):
            if int(num[u]) == ch[y]:
                count+=1
    return count
def move():
    if goal_ch == 100:
        return 0
    a = is_there(goal_ch)
    if a == len(str(goal_ch)): #숫자가 모두 있으면 그 숫자 만큼만 누르면 됨.
        to_ch.append(len(str(goal_ch)))
    else:
        n=0
        while n < 5000000:
            if is_there(n) == len(str(n)):
                to_ch.append(len(str(goal_ch)) + abs(n-goal_ch))
            n+=1
    to_ch.sort()
    return to_ch[0]

if broken != 0:
    b_ch = list(map(int, input().split()))
    for i in range(broken):
        ch.remove(b_ch[i])
    print(move())
else:
    print(move())