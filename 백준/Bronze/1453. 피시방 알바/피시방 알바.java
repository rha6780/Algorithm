import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		boolean[] isem=new boolean[102];
		int count=0;
		for(int i=0; i<N; i++) {
			int a=sc.nextInt();
			if(isem[a]==false) {isem[a]=true;}
			else {count++;}
		}
		System.out.println(count);

	}

}
