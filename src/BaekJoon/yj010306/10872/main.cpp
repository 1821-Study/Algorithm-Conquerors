#include <stdio.h>

int fac(int x)
{
	if (x == 1)
	{
		return x;
	}
	else
	{
		x *= fac(x - 1);
		return x;
	}
}

int main()
{
	int a;

	scanf_s("%d", &a);

	if (a == 0) printf("1");
	else printf("%d", fac(a));
	

	return 0;
}