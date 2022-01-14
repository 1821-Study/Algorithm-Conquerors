#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int tall[9];
int real[7];

int comp(const void *a, const void *b);

int main() {
	int sum = 0;
	int suc = 0;
	for (int i = 0; i < 9; i++) {
		scanf("%d", &tall[i]);
		sum += tall[i];
	}

	sum = sum - 100;

	for (int i = 0; i < 9; i++) {
		for (int j = i+1; j < 9; j++) {
			if (tall[i] + tall[j] == sum&& i!=j &&suc==0) {
				tall[i] = INT_MAX-1;
				tall[j] = INT_MAX-1;
				suc = 1;
			}
		}
	}


	qsort(tall, 9, sizeof(int), comp);

	for (int i = 0; i < 7; i++) {
		printf("%d\n", tall[i]);
	}
}

int comp(const void *a, const void *b) {
	if (*(int*)a > *(int*)b) {
		return 1;
	}
	else if (*(int*)a < *(int*)b) {
		return -1;
	}
	else
		return 0;
}