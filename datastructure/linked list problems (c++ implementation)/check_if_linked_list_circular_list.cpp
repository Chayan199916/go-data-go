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

void check_list(struct Node *check_head){
    struct Node *ptr = check_head;
    if(!ptr){
        cout << "Circular list" << endl;
        return;
    }
    else{
        ptr = ptr -> next;
        while(ptr && ptr != check_head){
            ptr = ptr -> next;
        }
        if(!ptr)
            cout << "Not Circular list" << endl;
        else
            cout << "Circular list" << endl;
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

struct Node *circ_head = NULL;
void create_circular_list(){
    struct Node *q;
    circ_head = new Node;
    circ_head -> data = 1;
    circ_head -> next = new Node;
    circ_head -> next -> data = 1;
    circ_head -> next -> next = new Node;
    circ_head -> next -> next -> data = 1;
    circ_head -> next -> next -> next = new Node;
    circ_head -> next -> next -> next -> data = 1;
    circ_head -> next -> next -> next -> next = circ_head;
}

int main()
{
    int arr[5] = {1, 1, 1, 1, 1};
    // for(int i = 0; i < 5; i++){
    //     create_list(arr[i]);
    // }
    // show_list();
    // check_list(head);
    create_circular_list();
    check_list(circ_head);
    return 0;
}