#include <stdio.h>


char chess_ori[50][50] = { 0, };

int check(int a, int b, int cnt)
{
	if (chess_ori[a][b] == chess_ori[a + 1][b]) cnt++;
	if (chess_ori[a][b] == chess_ori[a][b+1]) cnt++;

	check(a + 1, b, cnt);
	check(a, b+1, cnt);

	return cnt;
}

int main()
{
	int n, m;
	int cnt = 0;

	scanf_s("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			scanf_s("%c", &chess_ori[i][j]);
		}
	}

	for (int i = 0; i < n - 8; i++)
	{
		for (int j = 0; j < n - 8; j++)
		{
			check(i,j,cnt);
			if (cnt < check(i, j, cnt)) cnt = check(i, j, cnt);
		}
	}

	printf("%d", cnt);

}