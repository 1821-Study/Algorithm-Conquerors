#include <stdio.h>

int main()
{
	int n, k;
	int coin = 0;
	int arr[10];

	scanf_s("%d %d", &n, &k);

	for (int i = 0; i < n; i++) scanf_s("%d", &arr[i]);

	coin += k / arr[n - 1];
	for (int i = n - 1; i >= 1; i--)
	{
		coin += (k % arr[i]) / arr[i - 1];
	}

	printf("%d", coin);


}