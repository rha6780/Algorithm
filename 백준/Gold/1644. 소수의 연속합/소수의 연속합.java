import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] sosu=new int[N+1];
		int nn=2;
		sosu[0]=2;sosu[1]=3;
		for(int j=4; j<=N; j++) {boolean iss=false;
		for(int i=2; i<=Math.sqrt(j); i++) {
			if(j%i==0) {iss=false; break;}
			else {iss=true;}
		}
		if(iss==true) {sosu[nn]=j;nn++;}
		}
		int a=0,b=0,count=0,sum=0;
		if(N==1) {System.out.println(0);}
		else {
		while(true) {
			if(sum>=N) {sum-=sosu[a++];}
			else if(b==nn) {break;}
			else sum+=sosu[b++];
			if(sum==N) {count++;	}
		}
		System.out.println(count);
		}
	}

}
