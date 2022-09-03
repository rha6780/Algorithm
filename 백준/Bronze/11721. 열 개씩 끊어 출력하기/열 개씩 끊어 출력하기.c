#include<stdio.h>
int main(){
	int i, j;
	char g[1001];
	gets(g);
	for(i=0; i<strlen(g); i++){
		printf("%c",g[i]);
		if(i%10==9)
		printf("\n");
	}
}