#include <iostream>
using namespace std;

struct Node
{
    int data;
    struct Node *next;
    struct Node *down;
} *head = NULL;

struct Node *push_in_2d_list(struct Node *head_ref, int data)
{
    struct Node *q;
    q = new Node;
    q->data = data;
    q->next = NULL;
    q->down = head_ref;
    head_ref = q;
    return head_ref;
}

void create_2d_list()
{
    head = push_in_2d_list(head, 30);
    head = push_in_2d_list(head, 8);
    head = push_in_2d_list(head, 7);
    head = push_in_2d_list(head, 5);
    head->next = push_in_2d_list(head->next, 20);
    head->next = push_in_2d_list(head->next, 10);
    head->next->next = push_in_2d_list(head->next->next, 50);
    head->next->next = push_in_2d_list(head->next->next, 22);
    head->next->next = push_in_2d_list(head->next->next, 19);
    head->next->next->next = push_in_2d_list(head->next->next->next, 45);
    head->next->next->next = push_in_2d_list(head->next->next->next, 40);
    head->next->next->next = push_in_2d_list(head->next->next->next, 35);
    head->next->next->next = push_in_2d_list(head->next->next->next, 28);
}

struct Node *merge(struct Node *first, struct Node *second)
{
    struct Node *result = NULL;
    struct Node *ptr = result, *q;
    if (!first)
        result = second;
    if (!second)
        result = first;
    if (first->data < second->data)
    {
        q = new Node;
        q->data = first->data;
        q->down = NULL;
        result = q;
        ptr = result;
        first = first->down;
    }
    else
    {
        q = new Node;
        q->data = second->data;
        q->down = NULL;
        result = q;
        ptr = result;
        second = second->down;
    }
    while (first && second)
    {
        if (first->data < second->data)
        {
            q = new Node;
            q->data = first->data;
            q->down = NULL;
            ptr->down = q;
            ptr = q;
            first = first->down;
        }
        else
        {
            q = new Node;
            q->data = second->data;
            q->down = NULL;
            ptr->down = q;
            ptr = q;
            second = second->down;
        }
    }
    while (first)
    {
        q = new Node;
        q->data = first->data;
        q->down = NULL;
        ptr->down = q;
        ptr = q;
        first = first->down;
    }
    while (second)
    {
        q = new Node;
        q->data = second->data;
        q->down = NULL;
        ptr->down = q;
        ptr = q;
        second = second->down;
    }
    return result;
}
void show_original_list()
{
    struct Node *ptr1 = head, *ptr2;
    while (ptr1)
    {
        ptr2 = ptr1;
        while (ptr2)
        {
            cout << ptr2->data << "\t";
            ptr2 = ptr2->down;
        }
        cout << endl;
        ptr1 = ptr1->next;
    }
}
struct Node *merged_list = NULL;
void flatten(struct Node *head_ref)
{
    struct Node *ptr = head_ref;
    merged_list = head_ref;
    while (ptr->next)
    {
        merged_list = merge(merged_list, ptr -> next);
        ptr = ptr -> next;
    }
    // merged_list = merge(merged_list, head_ref -> next);
    // merged_list = merge(merged_list, head_ref -> next -> next);
    // merged_list = merge(merged_list, head_ref -> next -> next -> next);
}

void show(struct Node *head_ref)
{
    struct Node *ptr = head_ref;
    while (ptr)
    {
        cout << ptr->data << "\t";
        ptr = ptr->down;
    }
}
int main()
{
    create_2d_list();
    flatten(head);
    cout << "Flattened list : " << endl;
    show(merged_list);
    cout << endl;
    cout << "Original list : " << endl;
    show_original_list();
    return 0;
}