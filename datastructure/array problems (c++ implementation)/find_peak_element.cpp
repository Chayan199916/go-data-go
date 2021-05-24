#include<iostream>
using namespace std;

void find_peak_element(int *arr, int len){
    int flag = 0;
    for(int i = 0; i < len; i++){
        if(i == 0 || i == len - 1){
            int j = i ? i - 1 : i + 1;
            if(arr[i] > arr[j]){
                cout << arr[i] << " is peak element" << endl;
                flag = 1;
            }
        }else{
            if(arr[i] > arr[i + 1] && arr[i] > arr[i - 1]){
               cout << arr[i] << " is peak element" << endl; 
                flag = 1;
            }
        }
    }
    if(!flag)
        cout << "No such peak element" << endl;
}

int main(){
    int arr[] = {10, 20, 15, 2, 23, 90, 67};
    int len = sizeof(arr) / sizeof(arr[0]);
    find_peak_element(arr, len);
    return 0;
}