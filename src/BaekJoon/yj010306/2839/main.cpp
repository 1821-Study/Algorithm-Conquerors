#include <stdio.h>

int main()
{
	int n, roop;

	scanf_s("%d", &n);


	if (n >= 5)
	{
		roop = n / 5;

		for (int i = roop; i >= 0; i--)
		{
			if ((n - (5 * i)) % 3 == 0)
			{
				printf("%d", i + (n - (5 * i)) / 3);
				break;
			}
			if (i == 0) printf("-1");
		}
	}

	else
	{
		if (n % 3 == 0) printf("%d", n / 3);
		else printf("-1");
	}
}