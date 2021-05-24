#include<iostream>
# define I 32767
using namespace std;

int graph[][8] = {{I, I, I, I, I, I, I, I},
                 {I, I, 25, I, I, I, 5, I},
                 {I, 25, I, 12, I, I, I, 10},
                 {I, I, 12, I, 8, I, I, I},
                 {I, I, I, 8, I, 16, I, 14},
                 {I, I, I, I, 16, I, 20, 18},
                 {I, 5, I, I, I, 20, I, I},
                 {I, I, 10, I, 14, 18, I, I}};

int spanning_tree[2][6], near_vertices[8] = {I, I, I, I, I, I, I, I};
int n = 7;

void perform_prims(){
    int min = I, first_co, second_co, i, j;
    for(i = 1; i <= n; i++){
        for(j = i; j <= n; j++){
            if(graph[i][j] < min){
                min = graph[i][j];
                first_co = i;
                second_co = j;
            }
        }
    }
    spanning_tree[0][0] = first_co;
    spanning_tree[1][0] = second_co;
    near_vertices[first_co] = 0;
    near_vertices[second_co] = 0;
    for(i = 1; i <= n; i++){
        if(near_vertices[i] != 0){
            if(graph[i][first_co] < graph[i][second_co]){
                near_vertices[i] = first_co;
            }
            else{
                near_vertices[i] = second_co;
            }
        }
    }
    for(i = 1; i < n - 1; i++){
        min = I;
        for(j = 1; j <= n; j++){
            if(near_vertices[j] != 0){
                if(graph[j][near_vertices[j]] < min){
                    min = graph[j][near_vertices[j]];
                    first_co = j;
                }
            }
        }
        spanning_tree[0][i] = first_co;
        spanning_tree[1][i] = near_vertices[first_co];
        near_vertices[first_co] = 0;
        for(j = 1; j <= n; j++){
            if(near_vertices[j] != 0){
                if(graph[j][first_co] < graph[j][near_vertices[j]]){
                    near_vertices[j] = first_co;
                }
            }
        }
    }
}

void show_tree(){
    for(int i = 0; i < n - 1; i++){
        cout << spanning_tree[0][i] << ", " << spanning_tree[1][i] << endl;
    }
}
int main(){
    perform_prims();
    show_tree();
    return 0;
} 