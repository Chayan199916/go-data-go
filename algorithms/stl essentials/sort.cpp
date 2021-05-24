#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    
    //sorting 
    vector<int> v{1, 2, 3, 4, 5};
    sort(v.begin(), v.end(), greater<int>());
    for(auto x : v){
        cout << x << endl;
    }
    //int arr[] = {1, 2, 3, 4, 5};
    // int n = sizeof(arr) / sizeof(arr[0]);
    // sort(arr, arr + n, greater<int>());
    // for(auto x : arr){
    //     cout << x << "\t";
    // }
    
    //partial sorting
    // vector<int> v{4, 5, 3, 2, 1};
    // partial_sort(v.begin(), v.begin() + 3, v.end());
    // vector<int>::iterator it;
    // for(it = v.begin(); it != v.end(); it++){
    //     cout << *it << endl;
    // }

    //nth element
    // vector<int> v{5, 1, 4, 3};
    // nth_element(v.begin(), v.begin() + 2, v.end());
    // for(auto x : v){
    //     cout << x << endl;
    // }

    //inplace merging
    // vector<int> v1{5, 4, 3, 2, 1};
    // vector<int> v2{9, 7, 5, 2, 0};
    // int n = sizeof(v1) / sizeof(v1[0]) + sizeof(v2) / sizeof(v2[0]);
    // vector<int> v3(10);
    // sort(v1.begin(), v1.end());
    // sort(v2.begin(), v2.end());
    // vector<int>::iterator it = copy(v1.begin(), v1.end(), v3.begin());
    // copy(v2.begin(), v2.end(), it);
    // inplace_merge(v3.begin(), it, v3.end());
    // for(auto x : v3){
    //     cout << x << "\t";
    // }
    //cout << n;
    return 0;
}