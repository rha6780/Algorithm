#include <stdio.h>

int main(){
    int count=0, i;
    int a[20],a1[20],k[20];
    
    
    scanf("%d\n", &count);
    for(i=0; i<count; i++){
        scanf("%d\n", &a[i]);
        k[i]=(a[i]*a[i]);
        
        if(a[i]<10)
            a1[i]=k[i]%10;
        else if((a[i]>=10)&&(a[i]<100))
            a1[i]=k[i]%100;
        else if((a[i]>=100)&&(a[i]<=1000))
            a1[i]=k[i]%1000;
       
    }     
    for(i=0; i<count; i++)
        if(a1[i]==a[i])
           printf("YES\n");
        else
            printf("NO\n");
    
    
}