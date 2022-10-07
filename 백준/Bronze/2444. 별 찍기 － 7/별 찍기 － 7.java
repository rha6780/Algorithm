import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(j<N-i-1) {System.out.print(" ");}
				else System.out.print("*");
			}
			for(int j=0; j<i; j++) {System.out.print("*");}
			System.out.println();
		}
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N; j++) {
				if(j>i) {System.out.print("*");}
				else {System.out.print(" ");}
			}
			for(int j=0; j<N-1; j++) {
				if(j<N-2-i)System.out.print("*");
			}
			if(i!=N-2)System.out.println();
		}

	}

}
