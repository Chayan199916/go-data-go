#include<iostream>
using namespace std;
template<class T>
class sort_search
{
    T *arr;
    int size;
    public:
    sort_search(int);
    ~sort_search();
    void swap(T&,T&);
    void bubble_sort();
    void selection_sort();
    void insertion_sort();
    void linear_search(T);
    void binary_search(T);
    void display();
};
template<class T>
sort_search<T>::sort_search(int size)
{
    arr=new T[sort_search::size=size];
    int i;
    cout<<"enter the elements:"<<endl;
    for(i=0;i<size;i++)
    {
        cin>>arr[i];
    }
}
template<class T>
sort_search<T>::~sort_search()
{
    delete[] arr;
}
template<class T>
void sort_search<T>::swap(T &x,T &y)
{
    T m;
    m=x;
    x=y;
    y=m;
}
template<class T>
void sort_search<T>::bubble_sort()
{
    int i,j;
    for(i=0;i<size-1;i++)
    {
        for(j=0;j<size-1-i;j++)
        {
            if(arr[j]>arr[j+1])
            {
                swap(arr[j],arr[j+1]);
            }
        }
    }
}
template<class T>
void sort_search<T>::selection_sort()
{
    int i,k,j;
    T min;
    for(i=0;i<size-1;i++)
    {
        j=i;
        min=arr[i];
        k=i+1;
        while(k<size)
        {
            if(arr[k]<min)
            {
                min=arr[k];
                j=k;
            }
            k++;
        }
        swap(arr[i],arr[j]);
    }
}
template<class T>
void sort_search<T>::insertion_sort()
{
    int i,j;
    T temp;
    for(i=1;i<size;i++)
    {
        temp=arr[i];
        for(j=i-1;(j>=0)&&(temp<arr[j]);j--)
        {
            arr[j+1]=arr[j];
        }
        arr[++j]=temp;
    }
}
template<class T>
void sort_search<T>::linear_search(T val)
{
    int i,flag=0;
    for(i=0;i<size;i++)
    {
        if(arr[i]==val)
        {
            flag=1;
            break;
        }
    }
    if(flag==1)
    {
        cout<<"value found in the array"<<endl;
    }
}
template<class T>
void sort_search<T>::binary_search(T val)
{
    int i,j,mid,flag=0;
    i=0;
    j=size-1;
    mid=(i+((j-i)/2));
    while(i<=j)
    {
        if(arr[mid]==val)
        {
            flag=1;
            break;
        }
        else if(arr[mid]<val)
        {
            i=mid+1;
        }
        else
        {
            j=mid-1;
        }
        mid=(i+j)/2;   
    }
    if(flag==1)
    {
        cout<<"value found in the array:"<<endl;
    }
}
template<class T>
void sort_search<T>::display()
{
    int i;
    for(i=0;i<size;i++)
    {
        cout<<endl<<arr[i]<<"\t";
    }
}
int main()
{
    int size,val,m;
    cout<<"enter the size of the array:"<<endl;
    cin>>size;
    sort_search <int> ob1(size);
    cout<<"enter a value to search:\t";
    cin>>val;
    cout<<"enter the choice(1.bubble sort 2.selection sort 3.insertion sort):"<<endl;
    cin>>m;
    if(m==1)
    {
        ob1.bubble_sort();
    }
    if(m==2)
    {
        ob1.selection_sort();
    }
    if(m==3)
    {
        ob1.insertion_sort();
    }
    cout<<"enter the choice(1.linear search 2.binary search):"<<endl;
    cin>>m;
    if(m==1)
    {
        ob1.linear_search(val);
    }
    if(m==2)
    {
        ob1.binary_search(val);
    }
    cout<<"the sorted array is:"<<endl;
    ob1.display();
    return 0;
}