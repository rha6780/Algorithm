import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] num=new int[50001];
		int N=sc.nextInt();
		int nn=N;
		num[1]=1; num[2]=2; num[3]=3;
		for(int i=4; i<=N; i++) {
			if(i%Math.sqrt(i)==0) {num[i]=1;}
			else {
				int sq=(int)Math.sqrt(i);
				int ss=1; int min=99999;
				int dumy=0;
				while(ss<=sq) {
					dumy=num[i-(ss*ss)]+num[ss*ss];
					if(min>=dumy) {
						min=dumy;
					}
					ss++;
				}
				num[i]=min;
			}
	
		}
		System.out.println(num[N]);
	}
}