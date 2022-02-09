# 오답
import sys

num, wide, load = map(int, sys.stdin.readline().split())
truck = list(map(int, sys.stdin.readline().split()))

count = 0
cross_truck = 0
repeat = 0
n = 0

while n == 0:
    t_w = 0
    bridge_truck = 0
    for t_n in range(cross_truck, num):
        t_w += truck[t_n]
        bridge_truck += 1
        if t_w > load or t_n == num - 1:
            count += (wide + bridge_truck)
            cross_truck += bridge_truck
            if t_n == num - 1:
                n = 1
            break

print(count)
