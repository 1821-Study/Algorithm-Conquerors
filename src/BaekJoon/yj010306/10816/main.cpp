#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int Bi_cnt(int *arr, int length, int com){
    int start = 0;
    int end = length-1;
    int middle;
    int cnt=0;

    while(end - start >= 0) {
        middle = (start + end) / 2;

        if (arr[middle] == com) {


        }
        else if (arr[middle] > com) {
            end = middle - 1;

        }
        else {
            start = middle + 1;

        }
    }
    return cnt;
}

int main() {
    int n,m;

    scanf("%d", &n);
    int *A = new int[n];
    for(int i=0; i<n; i++){
        scanf("%d", &A[i]);
    }

    scanf("%d", &m);
    int *B = new int[m];
    for(int i=0; i<m; i++){
        scanf("%d", &B[i]);
    }

    sort(A, A+n);

    for(int i=0; i<m; i++){
        printf("%d\n", Bi_cnt(A, n-1, B[i]));
    }

    return 0;
}
