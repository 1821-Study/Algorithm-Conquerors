N = int(input())
M = int(input())
btn = [True] * 10  # 인덱스가 버튼의 번호
if M != 0:
    broken = list(map(int, input().split()))
    for b in broken:
        btn[b] = False


# 부서진 버튼이 있으면 -1, 아니면 채널 자릿수 리턴
def ButtonCount(num):
    cnt = 0
    for n in str(num):
        if not btn[int(n)]:
            return -1
        cnt += 1
    return cnt


res = abs(N - 100)  # 최소 +, - 만 이용해서 이동

# 목표 채널이 20인 경우 쓸데없이 1000같이 큰숫는 확인 필요없음
# 범위를 100000이 아닌 N + abs(N - 100)
for channel in range(N + abs(N - 100)):
    tmp = ButtonCount(channel)
    if tmp == -1:
        continue
    tmp += abs(channel - N)
    res = min(res, tmp)

print(res)
