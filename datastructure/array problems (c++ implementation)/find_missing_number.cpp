#include<iostream>
using namespace std;

void find_missing_number_sum_method(int *arr, int n){
    int expected_sum = n * (n + 1) / 2;
    int actual_sum = 0;
    for(int i = 0; i < n-1; i++){
        actual_sum += arr[i];
    }
    cout << "Missing number is : " << expected_sum - actual_sum << endl;
}

void find_missing_number_xor_method(int *arr, int n){
    int x1 = arr[0], x2 = 1;
    for(int i = 1; i < n - 1; i++)
        x1 = x1 ^ arr[i];
    for(int i = 2; i <= n; i++){
        x2 = x2 ^ i;
    }
    cout << "Missing number is : " << (x1 ^ x2) << endl;
}

int main(){
    int arr[7] = {1, 2, 4, 5, 3, 7, 8};
    // find_missing_number_xor_method(arr, 8);
    return 0;
}