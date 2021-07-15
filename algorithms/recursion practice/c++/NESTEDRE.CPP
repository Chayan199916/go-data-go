#include<iostream.h>
int fun(int n)
{
   if(n > 100)
		return n - 10;
   else
		return fun(fun(n + 11));
}
int main()
{
	int res;
	res = fun(30);
	cout << res << endl;
	return 0;
}