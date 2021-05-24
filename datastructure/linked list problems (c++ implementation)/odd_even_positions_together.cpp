#include<iostream>
using namespace std;

struct Node{
    int data;
    struct Node *next;
}*head = NULL;

void create_list(int data){
    struct Node *q;
    if(!head){
        q = new struct Node;
        q -> data = data;
        q -> next = NULL;
        head = q;
    }
    else{
            q = new struct Node;
            q -> data = data;
            q -> next = head;
            head = q;
        }
}

void show_list(struct Node *aux_head){
    struct Node *ptr = aux_head;
    while(ptr){
        cout << ptr -> data << "\t";
        ptr = ptr -> next;
    }
    cout << endl;
} 

struct Node * new_head = NULL;
void update_list(){
    struct Node *ptr = head;
    struct Node *r, *q;
    if(ptr){
    q = new Node;
    q -> data = ptr -> data;
    q -> next = NULL;
    new_head = q;
    r = new_head;
    ptr = ptr -> next;
    }
    if(!ptr)
        return;
    ptr = ptr -> next;
    while(ptr){
        struct Node *q = new Node;
        q -> data = ptr -> data;
        q -> next = NULL;
        r -> next = q;
        r = q;
        ptr = ptr -> next;
        if(!ptr)
            break;
        else
            ptr = ptr -> next;
    }
    ptr = head -> next;
    while(ptr){
        struct Node *q = new Node;
        q -> data = ptr -> data;
        q -> next = NULL;
        r -> next = q;
        r = q;
        ptr = ptr -> next;
        if(!ptr)
            break;
        else
            ptr = ptr -> next;
    }
}

int main(){
    int arr[3] = {4, 7, 3};
    for(int i = 0; i < 3; i++){
        create_list(arr[i]);
    }
    show_list(head);
    update_list();
    show_list(new_head);
    return 0;
}