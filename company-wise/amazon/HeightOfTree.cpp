#include<iostream>
#include<queue>
#include<stack>
using namespace std;

struct Node{

    int data;
    struct Node *left;
    struct Node *right;

}*root = NULL;

int findHeight(Node *start){

    int hl, hr, height;
    if(!start) return 0;
    hl = findHeight(start -> left);
    hr = findHeight(start ->right);
    height = hl > hr ? hl + 1 : hr + 1;
    return height;

}

void createTree(){

    Node *p, *temp;
    queue<Node*> q;
    int data;
    cout << "Enter the node values, -1 for null" << endl;
    cout << "Enter the root node" << endl;
    cin >> data;
    if(data != -1){

        p = new Node;
        p -> data = data;
        p->left = NULL;
        p ->right = NULL;
        q.push(p);
        root = p;

    }
    while(!q.empty()){

        temp = q.front();
        q.pop();
        cout << "Enter the left node of " << temp -> data << endl;
        cin >> data;
        if(data != -1){

            p = new Node;
            p -> data = data;
            p -> left = NULL;
            p -> right = NULL;
            temp -> left = p;
            q.push(p);

        }
        cout << "Enter the right node of " << temp -> data << endl;
        cin >> data;
        if(data != -1){

            p = new Node;
            p -> data = data;
            p -> left = NULL;
            p -> right = NULL;
            temp -> right = p;
            q.push(p);

        }
    }

}

int main(){

    createTree();
    cout << findHeight(root);
    return 0;

}