import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i-1<j) {System.out.print("*");}
				else {System.out.print(" ");}}
			for(int j=0; j<N-1; j++) {
				if(i-1<j)System.out.print("*");

			}
			if(i!=N-1)System.out.println();
		}

	}

}
