#include<stdio.h>

int main() {
	int a=0,a1,a2, b1,b2,i,count=0;
	scanf("%d",&a1);
	a = a1;
	
	for (i = 0;i>=0 ; i++) {
		b1 = a1 / 10;
		b2 = a1 % 10;
		a2 = b1 + b2;
		if (a2 / 10 != 0)
			a2 = a2 % 10;
		a1 =( b2 * 10) + a2;
		count++;
			if (a==a1) {
				break;
		}
	}
	printf("%d",count);
	
}