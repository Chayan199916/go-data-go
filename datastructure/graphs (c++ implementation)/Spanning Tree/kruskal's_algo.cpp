#include <iostream>
#define I 32767
using namespace std;

int edges[][9] = {
    {1, 1, 2, 2, 3, 4, 4, 5, 5},
    {2, 6, 3, 7, 4, 5, 7, 6, 7},
    {25, 5, 12, 10, 8, 16, 14, 20, 18}};

int n = 7;
int spanning_tree[2][6];
int set[8] = {-1, -1, -1, -1, -1, -1, -1, -1};
int visited[9] = {0};

void union_set(int u, int v)
{
    if (set[u] < set[v])
    {
        set[u] += set[v];
        set[v] = u;
    }
    else
    {
        set[v] += set[u];
        set[u] = v;
    }
}

int find_set(int x)
{
    int u = x;
    while (set[x] > 0)
    {
        x = set[x];
    }
    return x;
}

void perform_kruskal()
{
    int min, min_ptr;
    min = I;
    for (int i = 0; i < n - 1;)
    {
        min = I;
        for (int j = 0; j < 9; j++)
        {
            if (!visited[j] && edges[2][j] < min)
            {
                min = edges[2][j];
                min_ptr = j;
            }
        }
        visited[min_ptr]++;
        if(find_set(edges[0][min_ptr]) != find_set(edges[1][min_ptr])){
            spanning_tree[0][i] = edges[0][min_ptr];
            spanning_tree[1][i] = edges[1][min_ptr];
            union_set(find_set(edges[0][min_ptr]), find_set(edges[1][min_ptr]));
            i++;
        }
    }
}

void show_tree(){
    for(int i = 0; i < n - 1; i++){
        cout << spanning_tree[0][i] << ", " << spanning_tree[1][i] << endl;
    }
}

int main()
{
    perform_kruskal();
    show_tree();
    return 0;
}