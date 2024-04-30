#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int a = n/7;
    int b = n%7;
    if(b>1) {
        b=1;
    }
    return a+b;
}