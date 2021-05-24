#include<iostream>
#include<iostream>
#include<vector>
#include<queue>
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

void performBfs(vector<int> graph[], int vertices, int start){

    queue<int> q;
    int popped_ele;
    int visited[vertices] = {0};
    visited[start] = 1;
    q.push(start);
    while(!q.empty()){

        popped_ele = q.front();
        q.pop();
        cout << popped_ele << " ";
        for(auto it = graph[popped_ele].begin(); it != graph[popped_ele].end(); it++){

            if(!visited[*it]){

                visited[*it] = 1;
                q.push(*it);

            }

        }

    }

}

int main(){

    int vertices = 4; 
    vector<int> graph[vertices]; 

    createGraph(graph, 0, 1); 
    createGraph(graph, 0, 2); 
    createGraph(graph, 1, 2); 
    createGraph(graph, 2, 3); 
    // printGraph(graph, vertices);
    performBfs(graph, vertices, 3);
    return 0;

}