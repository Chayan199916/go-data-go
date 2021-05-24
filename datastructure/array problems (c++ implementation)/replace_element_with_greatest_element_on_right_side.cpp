#include<iostream>
using namespace std;

int find_max_from_subarray(int *arr, int start_index, int len){
    int max = arr[start_index];
    for(int i = start_index + 1; i < len; i++){
        if(arr[i] > max){
            max = arr[i];
        }
    }  
    return max;  
}

void show(int *arr, int len){
    for(int i = 0; i < len; i++){
        cout << arr[i] << "\t";
    }
    cout << endl;
}

void modify_array(int *arr, int len){
    int max;
    for(int i = 0; i < len; i++){
        if(i == len - 1)
            arr[i] = -1;
        else{
            max = find_max_from_subarray(arr, i + 1, len);
            arr[i] = max;
        }
    }
    show(arr, len);
}

void efficient_modify_array(int *arr, int len){
    int till_max, till_max_copy;
    for(int i = len - 1; i >= 0; i--){ 
        if(i == len - 1){
            till_max = arr[i];
            arr[i] = -1;
        }else{
            if(arr[i] > till_max){
                till_max_copy = till_max;
                till_max = arr[i];
            }
            arr[i] = till_max_copy;
            till_max_copy = till_max;
        }
    }
    show(arr, len);
}

int main(){
    int arr[] = {16, 17, 4, 3, 5, 2};
    int len = sizeof(arr) / sizeof(arr[0]);
    efficient_modify_array(arr, len);
    return 0;
}