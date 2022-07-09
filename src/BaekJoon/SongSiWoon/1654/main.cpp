#include <iostream>
#include <algorithm>
using namespace std;


int main(){
    unsigned int K, N, res = 0;
    cin >> K >> N;
    unsigned int lens[K];
    for (int i = 0; i < K; ++i) {
        scanf("%d", &lens[i]);
    }

    unsigned int start = 1;
    unsigned int end = *max_element(lens, lens + K);
    unsigned int mid;
    unsigned int cnt = 0;
    while (start <= end) {
        cnt = 0;
        mid = (start + end) / 2;

        for (int i = 0; i < K; i++) {
            cnt += (lens[i] / mid);
        }

        if (cnt >= N) {
            start = mid + 1;
            res = max(mid, res);
        } else {
            end = mid - 1;
        }
    }
    cout << res;
}
