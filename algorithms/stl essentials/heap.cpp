#include<iostream> 
#include<algorithm> // for heap  
#include<vector> 
using namespace std; 
  
int main() 
{ 
    // initializing vector; 
    vector<int> vi = { 4, 6, 7, 9, 11, 4 }; 
      
    // using make_heap() to transform vector into 
    // a max heap 
    make_heap(vi.begin(),vi.end()); 
      
    // //checking if heap using  
    // // front() function 
    // cout << "The maximum element of heap is : "; 
    // cout << vi.front() << endl; 

    vi.push_back(15);

    push_heap(vi.begin(), vi.end());

    // cout << "The maximum element of heap is : "; 
    // cout << vi.front() << endl; 

    // pop_heap(vi.begin(), vi.end());

    // cout << "The maximum element of heap is : "; 
    // cout << vi.front() << endl; 
    sort_heap(vi.begin(), vi.end());
    for(auto x : vi){
        cout << x << endl;
    }
} 