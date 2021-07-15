#include<iostream.h>
#include<conio.h>
int f[10];
int fib(int n)
{
	if(n <= 1)
		return n;
	return fib(n - 2) + fib(n - 1);
}
int memFib(int n)
{
	if(n <= 1)
	{
		f[n] = n;
		return n;
	}
	else
	{
		if(f[n - 2] == -1)
			f[n - 2] = memFib(n - 2);
		if(f[n - 1] == -1)
			f[n - 1] = memFib(n - 1);
		return f[n - 2] + f[n - 1];
	}
}
int sum(int n)
{
	if(n > 0)
	{
		return sum(n - 1) + n;
	}
	return 0;
}
int factorial(int n)
{
	if(n > 0)
	{
		return factorial(n - 1) * n;
	}
	return 1;
}
int power(int m, int n)
{
	if(n > 0)
	{
		return power(m, n - 1) * m;
	}
	return 1;
}
int main()
{
	int res;
	clrscr();
	for(int i = 0; i < 10; i++)
		f[i] = -1;
	res = memFib(7);
	cout << res;
	getch();
	return 0;
}