#include<iostream>
using namespace std;
void fun1(int n);
void fun2(int n);
int main()
{
    int x = 4;
    fun2(x);
    return 0;
}
void fun1(int n)
{
    if(n > 0)
    {
        cout << n << endl;
        fun1(n - 1);
    }
}
void fun2(int n)
{
    if(n > 0)
    {
        fun2(n - 1);
        cout << n << endl;
    }
}