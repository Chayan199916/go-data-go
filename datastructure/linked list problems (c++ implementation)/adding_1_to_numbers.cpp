#include<iostream>
#include<iterator>
#include<list>
#include<cmath>
using namespace std;

void show(list<int> x){
    list<int> :: iterator it;
    for(it = x.begin(); it != x.end(); it++){
        cout << *it << endl;
    }
}
void update_list(list<int> x){
    list<int> new_list;
    int len = x.size() - 1;
    int number = 0;
    for(auto it = x.begin(); it != x.end(); it++){
        number = number + (*it) * pow(10, len);
        len--;
    }
    number += 1;
    while(number > 0){
        int rem = number % 10;
        new_list.push_front(rem);
        number = number / 10;
    }
    show(new_list);
}
int main(){
    char num_digit;
    list<int> my_list;
    cout << "Enter a number(digits one by one.., press q to stop)" << endl;
    while(true){
        cin >> num_digit;
        if(num_digit == 'q' || num_digit == 'Q')
            break;
        my_list.push_back(num_digit - '0');
    }
    // show(my_list);
    update_list(my_list);
    return 0;
}