#include<iostream.h>
#include<conio.h>
double e(int x, int n)
{
	static double p = 1, f = 1;
	double r;
	if(n == 0)
		return 1;
	else
	{
		r = e(x, n - 1);
		p = p * x;
		f = f * n;
		return r + p / f;
	}
}
double ee(double x, double i, double n)
{
	if(i < n)
	{
		return (1 + ((x / i) * ee(x, i + 1, n)));
	}
	return 1;
}
int main()
{
	clrscr();
	cout << ee(1, 1, 10);
	getch();
	return 0;
}