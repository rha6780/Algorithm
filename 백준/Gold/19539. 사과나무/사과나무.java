import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] num=new int[N];
		int[] count=new int[2];
		for(int i=0; i<N; i++) {
			num[i]=sc.nextInt();
			count[1]+=num[i]/2;
			count[0]+=num[i]%2;
		}
		
		if(count[1]>count[0]) {
			count[1]-=count[0];
			if(count[1]%3==0) {System.out.println("YES");}
			else {System.out.println("NO");}
		}
		else if(count[1]==count[0]) {System.out.println("YES");}
		else {System.out.println("NO");}
		

	}

}
