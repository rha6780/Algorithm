import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.close();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i>=j) {System.out.print("*");}
				else {System.out.print(" ");}
			}
			for(int j=0; j<N; j++) {
				if(N-i-2<j) {System.out.print("*");}
				else System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N; j++) {
				if(N-2-i<j) {System.out.print(" ");}
				else System.out.print("*");;
			}
			for(int j=0; j<N; j++) {
				if(i<j) {System.out.print("*");}
				else System.out.print(" ");
			}
			if(i!=N-2) {System.out.println();}
		}

	}

}
