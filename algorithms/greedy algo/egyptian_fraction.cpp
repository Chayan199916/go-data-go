#include<iostream>

void printEgyptian(int numer, int denom){

    if (numer == 0 || denom == 0)
    {
        return;
    }
    if (denom % numer == 0)
    {
        std :: cout << "1 / " << denom / numer;
        return;
    }
    if(numer % denom == 0){
        std :: cout << numer / denom;
        return;
    }
    if(numer > denom){
        std :: cout << numer / denom << " + ";
        printEgyptian(numer % denom, denom);
    }
    if(numer < denom){
        std :: cout << "1 / " << denom / numer + 1 << " + ";
        printEgyptian(numer * (denom / numer + 1) - denom, (denom / numer + 1) * denom);
    }

}

int main(){

    int numer = 12, denom = 13;
    printEgyptian(numer, denom);
    return 0;

}