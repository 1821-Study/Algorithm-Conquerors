#include <iostream>
#include <string>
using namespace std;

int main(){
    int N;
    cin >> N;
    int start = 665;
    while (N > 0) {
        start++;
        if(to_string(start).find("666")!=string::npos) {
            N--;
        }
    }
    printf("%d", start);
}
