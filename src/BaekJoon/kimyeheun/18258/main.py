import sys
from collections import deque

n = int(sys.stdin.readline())
que = deque([])
for i in range(n):
    command = sys.stdin.readline().split()
    command_word = command[0]
    if command_word == 'push':
        que.appendleft(command[1])
    elif command_word == 'pop':
        if len(que) >= 1:
            print(que[-1])
            que.pop()
        else:
            print(-1)
    elif command_word == 'size':
        print(len(que))
    elif command_word == 'empty':
        if len(que) >= 1:
            print(0)
        else:
            print(1)
    elif command_word == 'front':
        if len(que) >= 1:
            print(que[-1])
        else:
            print(-1)
    elif command_word == 'back':
        if len(que) >= 1:
            print(que[0])
        else:
            print(-1)
