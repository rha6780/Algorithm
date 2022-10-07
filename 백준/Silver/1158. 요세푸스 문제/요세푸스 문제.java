import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt();
		boolean[] index=new boolean[N+1];
		System.out.print("<");
		int count=1; int c=0;
		for(int i=1; ; i++) {
			if(i>N) {i=1;}
			if(count==K) {
				if(index[i]==false) {
				if(c==N-1) {System.out.print(i+">"); break;}
				else System.out.print(i+", ");
				count=1; index[i]=true; c++;
				}
			}
			if(index[i]==false) {count++;}
		}
	}

}
