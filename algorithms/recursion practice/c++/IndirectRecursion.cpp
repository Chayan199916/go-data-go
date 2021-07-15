#include<iostream>
using namespace std;
void functionA(int n);
void functionB(int n);
int main()
{
    return 0;
}
void functionA(int n)
{
    if(n > 0)
    {
        cout << n << endl;
        functionB(n - 1);
    }
}
void functionB(int n)
{
    if(n > 0)
    {
        cout << n << endl;
        functionA(n / 2);
    }
}