#include <stdio.h>

int main()
{
	int n, m;
	int result=0;
	int arr[100] = { 0, };

	scanf_s("%d %d", &n, &m);

	for (int i = 0; i < n; i++) scanf_s("%d", &arr[i]);

	for (int i = 0; i < n - 2; i++)
	{
		for (int j = i + 1; j < n - 1; j++)
		{
			for (int k = j + 1; k < n; k++)
			{
				if (arr[i] + arr[j] + arr[k] <= m && arr[i] + arr[j] + arr[k] > result)
				{
					result = arr[i] + arr[j] + arr[k];
				}
			}
		}
	}

	printf("%d", result);

}