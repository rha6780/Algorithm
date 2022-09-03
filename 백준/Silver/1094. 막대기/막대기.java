import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int count=0;

		int[] hh= {64, 32, 16, 8, 4, 2, 1};
		for(int i=0; i<hh.length; i++) {
			if(N>=hh[i]) {N-=hh[i]; count++;}
			if(N==0) {System.out.println(count); break;}
		}

	}

}