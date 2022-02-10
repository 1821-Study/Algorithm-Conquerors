#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int bi(int *arr, int n, int com)
{
    int start = 0;
    int end = n;
    int middle;

    while(end - start >= 0){
        middle = (start + end)/2;

        if(arr[middle] == com){
            return 1;
        }
        else if(arr[middle] >= com ){
            end = middle-1;
        }
        else{
            start = middle+1;
        }
    }
    return 0;
}

int main() {
    int n,m;

    scanf("%d", &n);
    int* A = new int[n];
    for(int i=0; i<n; i++){
        scanf("%d", &A[i]);
    }

    scanf("%d", &m);
    int* B = new int[m];
    for(int i=0; i<m; i++){
        scanf("%d", &B[i]);
    }

    sort(A, A + n);

    for(int i=0; i<m; i++){
        printf("%d\n", bi(A, n-1, B[i]));
    }

    return 0;
}
