import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int a=sc.nextInt();
			String s=sc.next();
			char[] cc=s.toCharArray();
			for(int j=0; j<s.length(); j++) {
				if((j+1)!=a)System.out.print(cc[j]);
			}
			System.out.println();
		}
        sc.close();
	}

}
