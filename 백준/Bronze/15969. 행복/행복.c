#include <stdio.h>

int main(){
	int N;
	int score[1001];
	int min=9999, max=0, k, i;
	scanf("%d", &N);
	for(i=0; i<N; i++){
	scanf("%d", &score[i]);
	getchar();
}
	for(i=0; i<N; i++){
		if(min>=score[i]){
			min=score[i];
		}
		if(max<=score[i]){
			max=score[i];
		}
	}
	k=max-min;
	printf("%d", k);
}