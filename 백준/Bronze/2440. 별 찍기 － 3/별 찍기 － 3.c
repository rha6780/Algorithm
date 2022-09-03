#include <stdio.h>
int main(){
    int N, i,j;
    scanf("%d", &N);
    for(i=0; i<N; i++){
        for(j=i; j<N; j++)
            printf("*");
        printf("\n");
    }
}