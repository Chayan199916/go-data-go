#include <iostream>
#include <algorithm>
#include <random>
#include <vector>
using namespace std;

int main()
{
    vector<int> v{1, 2, 3};
    int c = 0;
    // rotate(v.begin(), v.begin() + 3, v.end()); // left rotation
    // rotate(v.begin(), v.begin() + (v.size() - 1), v.end()); // right rotation
    // shuffle(v.begin(), v.end(), default_random_engine());
    do
    {
        for (auto x : v)
        {
            cout << x << "\t";
        }
        cout << "\n";
        c++;
    }while(next_permutation(v.begin(), v.end()));
    // // cout << v.size() << endl;
    reverse(v.begin() + 2, v.end() - 2);
    for (auto x : v)
    {
        cout << x << "\t";
    }
    // cout << "Total permutations : " << c << endl;
    return 0;
}