#include<iostream>
#include<queue>
using namespace std;
        //         1
        //     2          3
        // 4      5  
        //       
    queue<int> graph_queue;    
    int graph[6][6] = {
        {0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 0, 0}, 
        {0, 1, 0, 0, 1, 1},
        {0, 1, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0},
        {0, 0, 1, 0, 0, 0}
    };
int visited[5];
void bfs(int start);
void dfs(int start);
int main(){

    for( int i = 0; i < 5; i++){
        // for( int j = 0; j < 5; j++)
        // {
        //     cout << graph[i][j] << "\t";
        // }
        visited[i] = 0;
        // cout << "\n";
    }
    // bfs(4);
    dfs(0);
    return 0;
}

void bfs(int start){
    int popped_ele;
    cout << start << endl;
    visited[start] = 1;
    graph_queue.push(start);
    while(!graph_queue.empty()){
        popped_ele = graph_queue.front();
        graph_queue.pop();
        for(int i = 0; i < 5; i++){
            if(graph[popped_ele][i] && !visited[i]){
                cout << i << endl;
                visited[i] = 1;
                graph_queue.push(i);
            }
        }
    }
}
void dfs(int start){
    if(!visited[start]){
        cout << start << endl;
        visited[start] = 1;
        for(int i = 0; i < 5; i++){
            if(graph[start][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}