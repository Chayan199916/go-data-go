#include <iostream>
using namespace std;

int find_longest_span(int *arr1, int *arr2)
{
    int span = 0;
    for (int i = 0; i < 7; i++)
    {
        int sum1 = 0, sum2 = 0;
        for (int j = i; j < 7; j++)
        {
            sum1 += arr1[j];
            sum2 += arr2[j];
            if (sum1 == sum2)
            {
                int len = (j -i + 1);
                if(len > span)
                    span = len;
            }
        }
    }
    return span;
}
int main()
{
    int arr1[] = {0, 1, 0, 1, 1, 1, 1}, arr2[] = {1, 1, 1, 1, 1, 0, 1};
    cout << "The longest span found is : " << find_longest_span(arr1, arr2);
    return 0;
}