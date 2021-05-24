#include<iostream>
#include<unordered_map>
using namespace std;

// [2, 3, 4, 4, 4, 4, 4, 6, 8]

int find_max(int *arr, int len){
    int max = arr[0];
    for(int i = 1; i < len; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }
    return max;
}

void find_majority(int *arr, int len, int max){
    int freq_arr[max] = {0}, flag = 0;
    for(int i = 0; i < len; i++){
        freq_arr[arr[i]]++;
    }
    for(int i = 0; i < max; i++){
        if(freq_arr[i] > (len / 2)){
            flag = 1;
            cout << "Majority element is : " << i << " and occuring time is : " << freq_arr[i] << endl;
            break;
        }            
    }
    if(!flag)
        cout << "No such majority element" << endl;
}

void efficient_find_majority(int *arr, int len){
    unordered_map<int, int> umap;
    int flag = 0;
    for(int i = 0; i < len; i++){
        umap[arr[i]]++;
    }
    for(auto x : umap){
        if(x.second > (len / 2)){
            cout << "Majority element is : " << x.first << " and occuring time is : " << x.second << endl; 
            flag = 1;
            break;
        }
    }
    if(!flag)
        cout << "No such majority element" << endl;
}

int main(){
    int arr[] = {2, 3, 4, 6, 4, 4, 8, 4, 8};
    int len = sizeof(arr) / sizeof(arr[0]);
    // int max_element = find_max(arr, len);
    // find_majority(arr, len, max_element);
    efficient_find_majority(arr, len);
    return 0;
}