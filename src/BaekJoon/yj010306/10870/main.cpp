#include <stdio.h>


int fi(int x, int y, int cnt)
{
	if (cnt == 1) return y;
	else
	{
		y = fi(y, x + y, cnt-1);
		return y;
	}
}

int main()
{
	int n;

	scanf_s("%d", &n);

	if (n == 0) printf("0");
	else
	{
		printf("%d", fi(0, 1, n));
	}

}