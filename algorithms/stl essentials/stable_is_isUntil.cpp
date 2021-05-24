#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    vector<int> v{2, 5, 6, 7, 0, 1, 5, 6};
    // stable_sort(v.begin(), v.end());
    // for(auto x : v){
    //     cout << x << endl;
    // }
    // if(is_sorted(v.begin(), v.end())){
    //     cout << "The vector is sorted" << endl;
    // }
    // else
    // {
    //     cout << "The vector is not sorted" << endl;
    // }
    vector<int>::iterator ip = is_sorted_until(v.begin(), v.end());
    cout << "the first element in the vector that is not in the sorted order is "<< *ip << endl;
    cout << "number of elements those are in sorted order is : " << ip - v.begin() << endl;
    vector<int>::iterator ip2 = is_sorted_until(ip, v.end());
    cout << "the first element in the vector that is not in the sorted order is "<< *(ip2 - 1) << endl;
    return 0;
}