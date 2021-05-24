#include<iostream>
#include<unordered_map>
using namespace std;

bool is_odd(int freq){
    return freq % 2 != 0;
}

void check_number_occurance(int *arr, int len){
    unordered_map<int, int> umap;
    for(int i = 0; i < len; i++){
        umap[arr[i]]++;
    }
    for(auto x : umap){
        bool check = is_odd(x.second);
        if(check)
            cout << x.first << " has occured odd number of times." << endl;
    }
}


int main(){
    int arr[] = {1, 2, 3, 2, 3, 1, 3, 2};
    int len = sizeof(arr) / sizeof(arr[0]);
    check_number_occurance(arr, len);
    return 0;
}