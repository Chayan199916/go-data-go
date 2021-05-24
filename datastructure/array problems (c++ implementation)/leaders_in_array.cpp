#include<iostream>
using namespace std;

void find_leaders(int *arr, int n){

    cout << "Leaders are : " << endl;
    int max_till = arr[n - 1];
    cout << max_till << "\t";
    for(int i = n - 2; i >= 0; i--){
        if(arr[i] > max_till){
            max_till = arr[i];
            cout << max_till << "\t";
        }
    }
}

int main(){
    int arr[] = {16, 17, 4, 3, 5, 2}, len = sizeof(arr) / sizeof(arr[0]);
    find_leaders(arr, len);
    return 0;
}