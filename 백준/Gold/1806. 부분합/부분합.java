import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		int s=0,e=0, sum=0; 
		int Min=100001;
		while(true) {
			if(sum>=M) {sum-=arr[s++];
			if(Min>=(e-s+1)) {Min=e-s+1;}}
			else if(e==N) {break;}
			else {sum+=arr[e++];}
		}
		if(Min!=100001) {System.out.println(Min);}
		else {System.out.println(0);}
	}

}
