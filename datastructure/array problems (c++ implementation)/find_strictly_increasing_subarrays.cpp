#include<iostream>
using namespace std;

void find_subarray_count(int *arr, int len){
    int count = 0, start = 0, i;
    for(i = 1; i < len; i++){
        if(arr[i] < arr[i - 1]){
            if(i - start > 1){
                count++;
            }
            start = i;
        }       
    }
    if(i - start > 1)
        count++;
    cout << "The number of strictly increasing subarrays : " << count << endl;
}

int main(){
    int arr[] = {4, 1, 2, 3, 0, 8, 9, 8, 7, 4, 5, 6};
    int len = sizeof(arr) / sizeof(arr[0]);
    find_subarray_count(arr, len);
    return 0;
}