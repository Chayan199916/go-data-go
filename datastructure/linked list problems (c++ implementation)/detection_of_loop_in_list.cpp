#include<iostream>
using namespace std;

struct Node{
    int data;
    struct Node *next;
}*head = NULL;

void create_loop_list(){
    head = new Node;
    head -> data = 10;
    head -> next = new Node;
    head -> next -> data = 20;
    head -> next -> next = new Node;
    head -> next -> next -> data = 30;
    head -> next -> next -> next = new Node;
    head -> next -> next -> next -> data = 40;
    head -> next -> next -> next -> next = NULL;
}

void check_loop(){
    struct Node *ptr1, *ptr2;
    ptr1 = ptr2 = head;
    if(!ptr2){

        cout << "No loop exists!" << endl;
        return;
    }
    ptr2 = ptr2 -> next;
    if(!ptr2){

        cout << "No loop exists!" << endl;
        return;
    }
    while(ptr2 != head && ptr2){
        ptr1 -> next = head;
        ptr1 = ptr2;
        ptr2 = ptr2 -> next;
    }
    if(!ptr2)
        cout << "No loop exists!" << endl;
    else
        cout << "loop exists!" << endl;
}

int main(){
    create_loop_list();
    check_loop();
    return 0;
}