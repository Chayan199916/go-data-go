#include<iostream>
#include<vector>
#include<algorithm>
#include<numeric>
using namespace std;
int my_fun(int x, int y){
    return x * y;
}
int s = 1;
 int main(){
     vector<int> v{2, 4, 1, 6, 7, 6, 6, 8, 9, 6};
     int result[10];
    //  int c = count(v.begin(), v.end(), 6);
    //  cout << "The value occurs " << c << " times" << endl;
    cout << accumulate(v.begin(), v.end(), s, my_fun);
    partial_sum(v.begin(), v.end(), result, my_fun); 
    for(auto x : result){
        cout << x << endl;
    }
    return 0;
 }