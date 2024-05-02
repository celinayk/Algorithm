#include <string>
#include <vector>

using namespace std;

int solution(int n, int k) {
    int ans = 0;
    int m=0;
    ans = n*12000+k*2000;
    if(n>=10) {
        m=n/10;
    }
    return ans-(m*2000);
}