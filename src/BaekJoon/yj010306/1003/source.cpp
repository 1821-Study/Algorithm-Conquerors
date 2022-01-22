#include <stdio.h>

int memori_zero[3000] = {0, };
int memori_one[3000] = { 0, };

int fibonacci_zero(int n, int zero_cnt) 
{
    if (n == 0) {
        zero_cnt++;
        return zero_cnt;
    }
    else if (n == 1) {
        return zero_cnt;
    }
    else if (memori_zero[n] != 0) return memori_zero[n];
    else {
        return memori_zero[n] = fibonacci_zero(n-1,zero_cnt) + fibonacci_zero(n-2,zero_cnt);
    }
}

int fibonacci_one(int n, int one_cnt)
{
    if (n == 0) {
        return one_cnt;
    }
    else if (n == 1) {
        one_cnt++;
        return one_cnt;
    }
    else if (memori_one[n] != 0) return memori_one[n];
    else {
        return memori_one[n] = fibonacci_one(n - 1, one_cnt) + fibonacci_one(n - 2, one_cnt);
        
    }
}

int main()
{
    int t, n;

    scanf_s("%d", &t);

    for (int i = 0; i < t; i++) {
        scanf_s("%d", &n);
        printf("%d %d\n", fibonacci_zero(n, 0), fibonacci_one(n, 0));

    }
}