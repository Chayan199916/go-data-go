#include<iostream>
using namespace std;

int count_minimum_distance(int *arr, int num1, int num2, int len){
    int sum = num1 + num2, min_len = len + 1, count = 0, i = 0, chosen_num, j;
    while(i < len){
        if(arr[i] == num1 || arr[i] == num2){
            chosen_num = arr[i];
            j = i;
            break;
        }
        i++;
    }
    i = j;
    while(i < len){
            while(arr[i] != (sum - chosen_num) && i < len){
                if(arr[i] == chosen_num){
                    count = 0;
                }
                count++;
                i++;
            }
            if(count < min_len){
                min_len = count;
            }
            if(i == len - 1)
                break;
            chosen_num = sum - chosen_num;
            count = 0;
    }
    return min_len;
}

int main(){
    int arr[] = {1, 2};
    cout << "Min distance is : " << count_minimum_distance(arr, 1, 2, 2);
    return 0;
}