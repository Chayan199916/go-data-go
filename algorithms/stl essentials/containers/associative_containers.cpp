#include<set>
#include<iostream>
#include<iterator>
#include<unordered_map>
#include<map>
using namespace std;

int main(){
    // set<int> demo;
    // demo.insert(10);
    // demo.insert(20);
    // demo.insert(40);
    // demo.insert(40);
    // demo.insert(30);
    // demo.insert(50);
    // demo.insert(60);
    // for(auto itr = demo.begin(); itr != demo.end(); itr++)
    //     cout << *itr << endl;
    // // demo.erase(demo.begin(), demo.find(40));
    // // for(auto itr = demo.begin(); itr != demo.end(); itr++)
    // //     cout << *itr << endl;
    // cout << *demo.lower_bound(70);
    // cout << *demo.upper_bound(35);

    unordered_map<string, int> umap;
    umap["chayan"] = 6;
    umap["sanglap"] = 7;
    umap["manjistha"] = 9;
    for(auto x : umap){
        cout << x.first << "\t" << x.second  << endl;
    }
    umap.erase("chayan");
    for(auto x : umap){
        cout << x.first << "\t" << x.second  << endl;
    }
    cout << (umap.find("sanglap") != umap.end());
    umap.find("chayan");
    return 0;
}