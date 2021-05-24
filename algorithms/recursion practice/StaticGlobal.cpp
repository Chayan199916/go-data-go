#include<iostream>
using namespace std;
int fun1(int n);
int fun2(int n);
int main()
{
    int m = 5;
    int s = fun1(m);
    cout << s;
    return 0;
}
int  fun1(int n)
{
    static int x = 0;
    if(n > 0)
    {
        x++;
        //cout << n << endl;
        return fun1(n - 1) + x;
    }
    return 0;
}
int  fun2(int n)
{
    if(n > 0)
    {
        return fun2(n - 1) + n;
    }
    return 0;
}