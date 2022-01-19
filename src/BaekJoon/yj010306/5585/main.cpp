#include <stdio.h>

int main()
{
	int cost, cnt;
	int ch;

	scanf_s("%d", &cost);

	ch = 1000 - cost;

	cnt = (ch / 500) + (ch % 500) / 100 + (ch % 100) / 50 + (ch % 50) / 10 + (ch % 10) / 5+(ch % 5) / 1;

	printf("%d", cnt);

}