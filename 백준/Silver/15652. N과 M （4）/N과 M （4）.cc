#include<iostream>
#include<vector>
using namespace std;

vector<int>a;

void number(int K,int N,int M){
	if(M==0){
		for(auto i : a)cout << i << " ";
		cout << "\n";
		return;
	}
	for(int i=K;i<=N;i++){
		a.push_back(i);
		number(i,N,M-1);
		a.pop_back();
	}
	
}

int main(void){
	int N, M; cin >> N >> M;
	number(1,N,M);
}