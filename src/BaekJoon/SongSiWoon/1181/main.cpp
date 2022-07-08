#include <iostream>
#include <algorithm>

using namespace std;

bool cmp(string a, string b){
    if (a.length() != b.length()) {
        return a.length() < b.length();
    } else {
        return a < b;
    }
};
int main(){
    int N;


    cin >> N;
    string words[N];
    for (int i = 0; i < N; ++i) {
        cin >> words[i];
    }
    sort(words, words + N, cmp);

    cout << words[0] << endl;
    for (int i = 1; i < N; ++i) {
        if (words[i] == words[i - 1]) {
            continue;
        }
        cout << words[i] << endl;
    }
}
