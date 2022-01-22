hight, width = map(int, input().split())
check = []
line=[]
count_B = 0
count_W = 0
for i in range(hight):
    line.append(input())
for u in range(hight-7): #8개 묶음으로 몇번(세로)
    for y in range(width-7): #(가로)
        for t in range(u, u+8):
            for r in range(y, y+8):
               # 짝수 줄 짝수 번호를 고려함과 동시에 홀수 줄과 홀수 번호를 고려
                if (t%2 == 0 and r%2 == 0) or (t%2 !=0 and r%2 !=0):
                    if line[t][r] != 'B':
                        count_B += 1 #B가 아니면 B로 칠함 그 횟수
                    else:
                        count_W += 1 #B이면 W로 칠했을 때의 횟수
                else:
                    if line[t][r] != 'W':
                        count_B += 1 #B가 아니면 B로 칠함 그 횟수
                    else:
                        count_W += 1 #B이면 W로 칠했을 때의 횟수
        check.append(count_B)
        check.append(count_W)
        count_B = 0
        count_W = 0
check.sort()
print(check[0])
