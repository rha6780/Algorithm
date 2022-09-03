import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=1;
		while(true) {
			a=sc.nextInt();
			if(a==0) {return;}
			String s=sc.next();
			char[] arr=s.toCharArray();
			char[][] ar=new char[s.length()/a][a];
			int c=0;
			for(int j=0; j<s.length()/a; j++) {
				if(j%2==0) {
				for(int i=0; i<a; i++) {
					ar[j][i]=arr[c];
					c++;
				}}
				else {
					for(int i=a-1;i>=0; i--) {
						ar[j][i]=arr[c];
						c++;
					}
				}
			}
			for(int h=0; h<a; h++) {
			for(int j=0; j<s.length()/a; j++) {
				System.out.print(ar[j][h]);
			}
			}
			System.out.println();
		}

	}

}
