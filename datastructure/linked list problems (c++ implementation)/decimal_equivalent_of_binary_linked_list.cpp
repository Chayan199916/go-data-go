#include<iostream>
#include<cmath>
using namespace std;

struct Node{
    int data;
    struct Node *next;
}*head = NULL;

void create_list(int data){
    struct Node *q, *ptr = head;
    q = new Node;
    q -> data = data;
    q -> next = NULL;
    if(!head){
        head = q;
        ptr = head;
    }else{
        while(ptr -> next)
            ptr = ptr -> next;
        ptr -> next = q;
    }
}
int count = 0;
void show_list(){
    struct Node *ptr = head;
    while(ptr){
        count++;
        cout << ptr -> data << "\t";
        ptr = ptr -> next;
    }
}

int calc_decimal(){
    int result = 0;
    struct Node *ptr = head;
    while(ptr){
        result += ptr -> data * pow(2, --count);
        ptr = ptr -> next;
    }
    return result;
}
int main()
{
    int arr[5] = {1, 1, 1, 1, 1};
    for(int i = 0; i < 5; i++){
        create_list(arr[i]);
    }
    show_list();
    cout << "The equivalent decimal number = " << calc_decimal() << endl;
    return 0;
}