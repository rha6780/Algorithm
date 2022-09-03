import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt(); int L=sc.nextInt();
		int[] count=new int[N+1];
		count[1]=1;
		int result=0;
		int a=1;
		while(true) {
			if(count[a]%2==0) {a-=L; if(a<0) {a+=N;}}
			else {a+=L; if(a>=N) {a-=N;}}
			count[a]++;
			result++;
			if(count[a]>=M) {break;}
		}
		System.out.println(result);

	}

}
