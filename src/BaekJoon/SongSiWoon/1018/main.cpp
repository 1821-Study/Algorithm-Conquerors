#include <algorithm>
#include <cstdio>

using namespace std;

int N, M;
int WhiteFirst(int row, int col);
int BlackFirst(int row, int col);
char graph[51][51];
int main() {
    int res = 987654321;
    scanf("%d%d", &N, &M);

    for (int i = 0; i < N; ++i) {
        scanf("%s", &graph[i]);
    }

    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            res = min(res, WhiteFirst(i, j));
            res = min(res, BlackFirst(i, j));
        }
    }

    printf("%d", res);

}

int WhiteFirst(int row, int col) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (i % 2 == 0) {
                if (j % 2 == 0) {
                    if (graph[row + i][col + j] != 'W') {
                        cnt++;
                    }
                } else {
                    if (graph[row + i][col + j] != 'B') {
                        cnt++;
                    }
                }
            } else {
                if (j % 2 == 0) {
                    if (graph[row + i][col + j] != 'B') {
                        cnt++;
                    }
                } else {
                    if (graph[row + i][col + j] != 'W') {
                        cnt++;
                    }
                }
            }
        }
    }
    return cnt;
}

int BlackFirst(int row, int col) {
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (i % 2 == 0) {
                if (j % 2 == 0) {
                    if (graph[row + i][col + j] != 'B') {
                        cnt++;
                    }
                } else {
                    if (graph[row + i][col + j] != 'W') {
                        cnt++;
                    }
                }
            } else {
                if (j % 2 == 0) {
                    if (graph[row + i][col + j] != 'W') {
                        cnt++;
                    }
                } else {
                    if (graph[row + i][col + j] != 'B') {
                        cnt++;
                    }
                }
            }
        }
    }
    return cnt;
}
