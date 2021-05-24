#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Job{

    char id;
    int dead;
    int profit;
    static int counter;
    public:
        Job(){}
        Job(char id, int dead, int profit){

            this -> id = id;
            this -> dead = dead;
            this -> profit = profit;
            counter++;

        }
        char getId(){
            return this -> id;
        }
        int getDead(){
            return this -> dead;
        }
        char getProfit(){
            return this -> profit;
        }
        static int getNumberOfJobs(){
            return counter;
        }
};

int Job :: counter = 0;

void showSequence(vector<char> resultJobs){

    for(auto job : resultJobs){

            cout << job << " ";

    }

} 

bool compare(Job job1, Job job2){

    return job1.getProfit() > job2.getProfit();

}

void performSequencing(vector<Job> jobs){

    int numOfJobs = jobs.size();
    int slots[numOfJobs] = {0};
    char resultJobs[numOfJobs];
    sort(jobs.begin(), jobs.end(), compare);
    for(int i = 0; i < jobs.size(); i++){
        
        for(int j = min(numOfJobs, jobs[i].getDead()) - 1; j >= 0; j--){

            if(slots[j] == 0){

                slots[j] = 1;
                resultJobs[j] = jobs[i].getId();
                break;

            }

        }

    }
    for(char job : resultJobs){

            cout << job << " ";

    }
}


int main(){

    Job job1('a', 2, 100);
    Job job2('b', 1, 19);
    Job job3('c', 2, 27);
    Job job4('d', 1, 25);
    Job job5('e', 3, 15);
    vector<Job> jobs;
    jobs.push_back(job1);
    jobs.push_back(job2);
    jobs.push_back(job3);
    jobs.push_back(job4);
    jobs.push_back(job5);
    performSequencing(jobs);
    return 0;

}