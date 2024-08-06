#define _CRT_SECURE_NO_WARNINGS
#include <iostream> 
#include <algorithm>
#include <string>
#include <vector>
#include <math.h>
#include <cmath>
#include <cstring>
using namespace std;


struct MyStruct
{
    int age;
    string name;
};


bool compare(const MyStruct& fir, const MyStruct& sec) {
    if (fir.age != sec.age) { //나이가 다르면
        return fir.age < sec.age; //나이가 적은 사람부터 
    }
    return false;
} 


int main() {

    int n;
    scanf("%d ", &n);

    vector<MyStruct> str(n);

    for (int i = 0; i < n; i++) {
        cin >> str[i].age >> str[i].name;
    }

    stable_sort(str.begin(), str.end(),compare);

    for (int i = 0; i < n; i++) {
        cout << str[i].age << " " <<  str[i].name <<"\n";
    }


    return 0;
}
   