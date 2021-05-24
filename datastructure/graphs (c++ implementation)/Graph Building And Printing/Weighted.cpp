#include<iostream>
#include<vector>
using namespace std;

void createGraph(vector<pair<int, int>> graph[], int u, int v, int w){

    graph[u].push_back(make_pair(v, w));
    graph[v].push_back(make_pair(u, w));

}
void printGraph(vector<pair<int, int>> graph[], int vertices){

    for(int i = 0; i < vertices; i++){

        cout << i << " -> ";
        for(auto it = graph[i].begin(); it != graph[i].end(); it++){

            cout << "(" << it -> first << ", " << it -> second << ")" << " ";

        }
        cout << endl;

    }

}

int main(){

    int vertices = 5; 
    vector<pair<int, int>> graph[vertices]; 

    createGraph(graph, 0, 1, 10); 
    createGraph(graph, 0, 4, 20); 
    createGraph(graph, 1, 2, 30); 
    createGraph(graph, 1, 3, 40); 
    createGraph(graph, 1, 4, 50); 
    createGraph(graph, 2, 3, 60);
    createGraph(graph, 3, 4, 70); 
    printGraph(graph, vertices);

    return 0;

}