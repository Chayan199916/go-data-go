#include<iostream>
#include<queue>
#include<stack>
using namespace std;

struct Node{

    int data;
    struct Node *left;
    struct Node *right;

}*root = NULL;

void findMirror(Node *start){

    if(start -> left && start -> right){

        Node *temp = start -> left;
        start -> left = start -> right;
        start -> right = temp;
        findMirror(start -> left);
        findMirror(start -> right);

    }

}

void inorder(Node *start){

    if(start){

        inorder(start -> left);
        cout << start -> data << " ";
        inorder(start -> right);

    }

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
    findMirror(root);
    inorder(root);
    return 0;

}
