#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    string input;
    int i = 1;
    while (true) {
        cin >> input;
        if (input == "0") {
            break;
        }
        string rev = input;
        reverse(rev.begin(), rev.end());

        if (input == rev) {
            printf("yes\n");
        } else {
            printf("no\n");
        }
        i++;
    }
}
