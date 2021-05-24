#include<iostream>
using namespace std;

void show(int *show_array, int len){
    for(int i = 0; i < len; i++){
        if(show_array[i] == -1){
            continue;
        }else{
            cout << show_array[i] << "\t";
        }
    }
    cout << endl;
}

void find_union(int *arr1, int *arr2){
    int union_set[9], count = 0, flag;
    for(int i = 0; i < 5; i++){
        flag = 0;
        for(int j = 0; j < 4; j++){
            if(arr1[i] == arr2[j]){
                union_set[count++] = arr1[i];
                arr2[j] = -1;
                flag = 1;
            }
        }
        if(!flag)
            union_set[count++] = arr1[i];
    }
    for(int j = 0; j < 4; j++){
        if(arr2[j] != -1){
            union_set[count++] = arr2[j];
        }
    }
    for(int j = count; j < 9; j++){
        union_set[j] = -1;
    }
    cout << "Union is : " << endl;
    show(union_set, 9);
}

void find_intersection(int *arr1, int *arr2){
    int intersection_set[5], count = 0;
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 4; j++){
            if(arr1[i] == arr2[j]){
                intersection_set[count++] = arr1[i];
            }
        }
    }
    for(int j = count; j < 5; j++){
        intersection_set[j] = -1;
    }
    cout << "Intersection is : " << endl;
    show(intersection_set, 5);
}

void efficient_union_intersection(int *arr1, int *arr2, int len1, int len2){
    int union_set[len1 + len2], intersection_set[len1], count1 = 0, count2 = 0, i, j;
    for(i = 0, j = 0; i < len1 && j < len2;){
        if(arr1[i] < arr2[j]){
            union_set[count1++] = arr1[i++];
        }else if(arr2[j] < arr1[i]){
            union_set[count1++] = arr2[j++];
        }else{
            union_set[count1++] = arr1[i];
            intersection_set[count2++] = arr1[i];
            i++;
            j++;
        }
    }
    while(i < len1)
        union_set[count1++] = arr1[i++];
    while(j < len2)
        union_set[count1++] = arr2[j++];
    for(int i = count1; i < len1 + len2; i++)
        union_set[i] = -1;
    for(int i = count2; i < len1; i++)
        intersection_set[i] = -1;
    cout << "Union set : " << endl;
    show(union_set, len1 + len2);
    cout << "Intersection set : " << endl;
    show(intersection_set, len1);
}

int main(){
    int arr1[] = {1, 3, 4, 5, 7}, arr2[] = {2, 3, 5, 6};
    efficient_union_intersection(arr1, arr2, 5, 4);
    return 0;
}