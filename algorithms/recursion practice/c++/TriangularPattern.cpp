#include<iostream>

void printPattern(int n){

    if(n > 1) printPattern(n - 1);
    for(int i = 0; i < n; i++) std::cout << "*";
    std::cout << std::endl;
    
}

int main(){
    
    printPattern(5);
    return 0;

}