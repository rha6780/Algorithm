#include <stdio.h>
#include <string.h>
#define N 1000001
int main(){
    int count=1;
	int i;
    char words[N]={0,};
    gets(words);
    for(i=0; i<=strlen(words)-1;i++){
    	if((words[i]==' ')&&(words[i+1]!='\0'))
        	++count;
     }
     if((words[0]=='\0')||(words[0]==' ')){
     	count--;
	 }
	printf("%d", count);
}