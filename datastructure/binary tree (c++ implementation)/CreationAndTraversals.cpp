#include <iostream>
#include <queue>
#include <stack>
using namespace std;

struct Node
{

    int data;
    struct Node *left;
    struct Node *right;

} *root = NULL;

void preOrderRecursive(Node *start)
{

    if (start)
    {

        cout << start->data << " ";
        preOrderRecursive(start->left);
        preOrderRecursive(start->right);
    }
}
void preOrderIterative(Node *start)
{

    stack<Node *> s;
    while (start || !s.empty())
    {

        if (start)
        {

            cout << start->data << " ";
            s.push(start);
            start = start->left;
        }
        else
        {

            start = s.top();
            s.pop();
            start = start->right;
        }
    }
}

void inOrderRecursive(Node *start)
{

    if (start)
    {

        inOrderRecursive(start->left);
        cout << start->data << " ";
        inOrderRecursive(start->right);
    }
}

void inOrderIterative(Node *start)
{

    stack<Node *> s;
    while (start || !s.empty())
    {

        if (start)
        {

            s.push(start);
            start = start->left;
        }
        else
        {

            start = s.top();
            s.pop();
            cout << start->data << " ";
            start = start->right;
        }
    }
}
void postOrderRecursive(Node *start)
{

    if (start)
    {

        postOrderRecursive(start->left);
        postOrderRecursive(start->right);
        cout << start->data << " ";
    }
}

void postIterativeTwoStacks(Node *start)
{

    stack<Node *> s1, s2;
    Node *temp;
    s1.push(start);
    while (!s1.empty())
    {

        temp = s1.top();
        s1.pop();
        s2.push(temp);
        if (temp->left)
            s1.push(temp->left);
        if (temp->right)
            s1.push(temp->right);
    }
    while (!s2.empty())
    {

        cout << s2.top()->data << " ";
        s2.pop();
    }
}

void postIterativeOneStack(Node *start)
{

    stack<Node *> s;
    Node *topElement;
    do
    {
        while (start)
        {
            if (start->right)
            {
                s.push(start->right);
            }
            s.push(start);
            start = start->left;
        }
        start = s.top();
        s.pop();
        if (start->right && !s.empty() && start->right == s.top())
        {
            s.pop();
            s.push(start);
            start = start->right;
        }
        else
        {
            cout << start->data << "\t";
            start = NULL;
        }

    } while (!s.empty());
}

void levelOrder(Node *start)
{

    queue<Node *> q;
    Node *temp;
    temp = start;
    q.push(temp);
    while (!q.empty())
    {

        temp = q.front();
        q.pop();
        cout << temp->data << " ";
        if (temp->left)
        {

            q.push(temp->left);
        }
        if (temp->right)
        {

            q.push(temp->right);
        }
    }
}

int getHeight(Node *start){

    int lh, rh;
    if (!start)
        return 0;
    lh = getHeight(start -> left);
    rh = getHeight(start ->right);
    return lh > rh ? lh + 1 : rh + 1;
} 

int countNodes(Node *start){

    if (!start)
        return 0;
    else
        return countNodes(start -> left) + countNodes(start -> right) + 1;
    
}

int countLeafNodes(Node *start){

    while (start)
    {
        if (!(start -> left) && !(start -> right))
        {
            return 1;
        }else
        {
            return countLeafNodes(start -> left) + countLeafNodes(start -> right);
        }
        
    }
    return 0;
}

void createTree()
{

    Node *p, *temp;
    queue<Node *> q;
    int data;
    cout << "Enter the node values, -1 for null" << endl;
    cout << "Enter the root node" << endl;
    cin >> data;
    if (data != -1)
    {

        p = new Node;
        p->data = data;
        p->left = NULL;
        p->right = NULL;
        q.push(p);
        root = p;
    }
    while (!q.empty())
    {

        temp = q.front();
        q.pop();
        cout << "Enter the left node of " << temp->data << endl;
        cin >> data;
        if (data != -1)
        {

            p = new Node;
            p->data = data;
            p->left = NULL;
            p->right = NULL;
            temp->left = p;
            q.push(p);
        }
        cout << "Enter the right node of " << temp->data << endl;
        cin >> data;
        if (data != -1)
        {

            p = new Node;
            p->data = data;
            p->left = NULL;
            p->right = NULL;
            temp->right = p;
            q.push(p);
        }
    }
}

int main()
{

    createTree();
    // cout << "Preorder traversal : " << endl;
    // preOrderIterative(root);
    // cout << "\nInorder traversal : " << endl;
    // inOrderIterative(root);
    // cout << "\nPostorder traversal : " << endl;
    // postIterativeOneStack(root);
    // cout << "\nLevelorder traversal : " << endl;
    // levelOrder(root);
    // cout << getHeight(root) << endl;
    cout << countLeafNodes(root) << endl;
    return 0;
}