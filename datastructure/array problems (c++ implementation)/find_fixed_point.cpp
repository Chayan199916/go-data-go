#include<iostream>
using namespace std;

void find_fixed_point(int *arr, int len){
    int flag = 0;
    for(int i = 0; i < len; i++){
        if(arr[i] == i){
            cout << "Fixed point is : " << i << endl;
            flag = 1;
        }
    }
    if(!flag)
        cout << "No such Fixed point" << endl;
}

int main(){
    int arr[] = {-10, -5, 0, 3, 7};
    int len = sizeof(arr) / sizeof(arr[0]);
    find_fixed_point(arr, len);
    return 0;
}