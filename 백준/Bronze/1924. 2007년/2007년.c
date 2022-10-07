#include <stdio.h>
int main(){
    int x,y, i, j,m, M=0;
    char d;
    scanf("%d %d", &x,&y);
    for(i=1; i<x; i++){
    if((i<=7)&&(i%2!=0)){
      M+=31;
  }
    else if((i>7)&&(i%2==0)){
            M+=31;
        }
     else if(i==2){
            M+=28;
        }
     else{
         M+=30;
     }      
}
M+=y;
m=M%7;
switch(m){
    case (1):printf("MON");break;
    case (2):printf("TUE");break;
    case (3):printf("WED");break;
    case (4):printf("THU");break;
    case (5):printf("FRI");break;
    case (6):printf("SAT");break;
    case (0):printf("SUN");break;
}
}