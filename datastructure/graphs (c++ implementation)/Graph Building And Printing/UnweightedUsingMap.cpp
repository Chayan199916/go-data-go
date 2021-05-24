#include<iostream>
#include<map>
#include<vector>
using namespace std;

void buildGraph(map<int, vector<int>> graph, vector<int> vertices, int org){

    graph[org] = vertices;

}

void printGraph(map<int, vector<int>> graph){

    for (int i = 0; i < graph.size(); i++)
    {
        
        for(auto ele : graph[i]){

            cout << ele << "\t";

        }
        cout << endl;

    }
    

}

int main(){

    map<int, vector<int>> graph;
    vector<int> vertices;
    int vertex;
    // buildGraph(graph, 0, 2);
    // buildGraph(graph, 0, 1);
    // buildGraph(graph, 1, 2);
    // buildGraph(graph, 1, 3);
    // buildGraph(graph, 2, 3);

    for (int i = 0; i <= 3; i++)
    {
        cout << "Enter adjacent vertices of " << i << endl;
        cin >> vertex;
        while (vertex != -1)
        {
            vertices.push_back(vertex);
            cin >> vertex;
        }
        buildGraph(graph, vertices, i);
        vertices.clear();

    }
    
    cout << graph.size();
    printGraph(graph);

    return 0;

}