#include <stdio.h>
int main(){
    int N, i,result=0;
    scanf("%d", &N);
        for(i=1; i<=N; i++){
            result+=i;
        }
    printf("%d", result);
}