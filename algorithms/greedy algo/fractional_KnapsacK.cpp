// Input:
// Items as (value, weight) pairs
// arr[] = {{60, 10}, {100, 20}, {120, 30}}
// Knapsack Capacity, W = 50;
// Output:
// Maximum possible value = 240
// by taking items of weight 10 and 20 kg and 2/3 fraction
// of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(pair<int, int> p1, pair<int, int> p2){

    double result1 = (double)p1.first / (double)p1.second;
    double result2 = (double)p2.first / (double)p2.second;
    return result1 > result2;

}

double implementKnapSack(vector< pair<int, int> > v, int n, int w){

    sort(v.begin(), v.end(), compare);
    int curWeight = 0;
    double curValue = 0;
    for(auto ele : v){
        
        if(curWeight + ele.second <= w){

            curWeight += ele.second;
            curValue += ele.first;
        
        } else{

            curValue += double(w - curWeight) / (double)ele.second * (double)ele.first;
            break;

        }

    }
    return curValue;

}

int main(){

    vector<pair<int, int>> arr;
    arr.push_back(make_pair(60, 10));
    arr.push_back(make_pair(100, 20));
    arr.push_back(make_pair(120, 30));
    int totWeight = 50;
    cout << "Maximum possible value = " << implementKnapSack(arr, arr.size(), totWeight);
    return 0;

}