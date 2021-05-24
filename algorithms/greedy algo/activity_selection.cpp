// Example 1 : Consider the following 3 activities sorted by
// by finish time.
//      start[]  =  {10, 12, 20};
//      finish[] =  {20, 25, 30};
// A person can perform at most two activities. The 
// maximum set of activities that can be executed 
// is {0, 2} [ These are indexes in start[] and 
// finish[] ]

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

bool compare(pair<int, int> p1, pair<int, int> p2){

    return p1.second < p2.second;

}

void implementActivitySelection(vector< pair<int, int> > v){

    auto it = v.begin(), tracker = v.begin();
    sort(v.begin(), v.end(), compare);
    cout << "Chosen activities : " << endl;
    cout << (*it).first << " " << (*it).second << endl;
    it++;
    for(it; it != v.end(); it++){

        if ((*it).first >= (*tracker).second)
        {
            cout << (*it).first << " " << (*it).second << endl;
            tracker++;
        }
    }

}

int main(){

    vector<pair<int, int>> v;
    int start[]  =  {1, 3, 0, 5, 8, 5};
    int finish[] =  {2, 4, 6, 7, 9, 9};
    for(int i = 0; i < sizeof(start) / sizeof(start[0]); i++){
        v.push_back(make_pair(start[i], finish[i]));
    }
    implementActivitySelection(v);
    return 0;

}