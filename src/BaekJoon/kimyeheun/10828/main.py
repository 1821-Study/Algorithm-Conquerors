class Proceed:
    def __init__(self):
        self.a = []
    def push(self, num):
        self.a.append(num)
    def pop(self):
        if len(self.a) >= 1:
            lose_num = self.a[-1]
            self.a.pop()
            return lose_num
        else:
            return -1
    def size(self):
        return len(self.a)
    def empty(self):
        if len(self.a) >= 1:
            return 0
        else:
            return 1
    def top(self):
        if len(self.a) >= 1:
            return self.a[-1]
        else:
            return -1

import sys

n = int(sys.stdin.readline())
p = Proceed()
for i in range(n):
    command = sys.stdin.readline().split()
    command_word = command[0]
    if command_word == 'push':
        p.push(command[1])
    elif command_word == 'pop':
        print(p.pop())
    elif command_word == 'size':
        print(p.size())
    elif command_word == 'empty':
        print(p.empty())
    elif command_word == 'pop':
        print(p.pop())
    elif command_word == 'top':
        print(p.top())
