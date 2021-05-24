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

void show_list(){
    struct Node *ptr = head;
    while(ptr){
        cout << ptr -> data << "\t";
        ptr = ptr -> next;
    }
    cout << endl;
} 

void update_list(int m, int n){
    struct Node *ptr = head;
    struct Node *q = head, *del;
    if(!m){
        while(ptr){
            for(int i = 1; i <= n; i++){
                head = ptr -> next;
                q = head;
                del = ptr;
                ptr = ptr -> next;
                del -> next = NULL;
                delete(del);
                if(!ptr)
                    break;
            }
        }
    }else{

        while(ptr){
            for(int i = 1; i <= m; i++){
                q = ptr;
                ptr = ptr -> next;
                if(!ptr)
                    break;
            }
            if(ptr){
                for(int i = 1; i <= n; i++){
                    q -> next = ptr -> next;
                    del = ptr;
                    ptr = ptr -> next;
                    del -> next = NULL;
                    delete(del);
                    if(!ptr)
                        break;
                }
            }
        }
    }
}
int main(){
    int arr[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for(int i = 0; i < 10; i++){
        create_list(arr[i]);
    }
    show_list();
    update_list(1, 1);
    show_list();
    return 0;
}
