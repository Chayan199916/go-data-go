#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool isOdd(int i){
    return i % 2 != 0;
}
int main(){
    vector<int> v{5, 6, 3, 8, 1, 2};
    partition(v.begin(), v.end(), isOdd);
    auto it = partition_point(v.begin(), v.end(), isOdd);
    for(auto x : v){
        cout << x << "\t";
    }
    cout << "\n";
    cout << *it ;
    return 0;
}