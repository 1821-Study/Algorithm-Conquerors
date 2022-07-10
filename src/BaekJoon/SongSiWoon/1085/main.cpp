#include <algorithm>

using namespace std;
int main(){
    int x, y, w, h;
    scanf("%d%d%d%d", &x, &y, &w, &h);
    int rx = w - x;
    int ry = h - y;
    int res = min({x, y, rx, ry});
    
    printf("%d", res);
}