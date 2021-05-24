#include<iostream>
#include<vector>
using namespace std;

void createGraph(vector<int> graph[], int u, int v){

    graph[u].push_back(v);
    graph[v].push_back(u);

}
void printGraph(vector<int> graph[], int vertices){

    for(int i = 0; i < vertices; i++){
        
        cout << i << " -> ";
        for(auto it = graph[i].begin(); it != graph[i].end(); it++){

            cout << *it << " ";

        }
        cout << endl;

    }

}

int main(){

    int vertices = 5; 
    vector<int> graph[vertices]; 

    createGraph(graph, 0, 1); 
    createGraph(graph, 0, 4); 
    createGraph(graph, 1, 2); 
    createGraph(graph, 1, 3); 
    createGraph(graph, 1, 4); 
    createGraph(graph, 2, 3);
    createGraph(graph, 3, 4); 
    printGraph(graph, vertices);

    return 0;

}