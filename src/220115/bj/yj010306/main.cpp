#include <stdio.h>

int main()
{
	int n;
	int star_cnt=1;

	scanf("%d", &n);

	for (int i = n-1; i >= 0; i--)
	{
		for (int j = i; j > 0; j--)
		{
			printf(" ");
		}
		for (int k = 0; k < star_cnt; k++)
		{
			printf("*");
		}
		printf("\n");
		star_cnt += 2;
	}

	star_cnt -= 4;

	for (int i = 1; i < n; i++)
	{
		for (int j = 0; j < i; j++)
		{
			printf(" ");
		}
		for (int k = 0; k < star_cnt; k++)
		{
			printf("*");
		}
		printf("\n");
		star_cnt -= 2;
	}

}
