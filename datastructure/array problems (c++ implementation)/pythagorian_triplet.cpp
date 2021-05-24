#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    int arr[] = {3, 1, 4, 6, 5};
    int len = sizeof(arr) / sizeof(arr[0]);
    vector<int> v(arr, arr + len);
    do{
        for(auto x : v){
            cout << x << "\t";
        }
        cout << endl;
    }while(next_permutation(v.begin(), v.end()));
    return 0;
}