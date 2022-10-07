import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0; i<t; i++) {
			int n=sc.nextInt();
			String s=sc.next();
			char[] alp=s.toCharArray();
			String str="";
			for(int j=0; j<s.length(); j++) {
				for(int h=0; h<n; h++) {
				str+=alp[j];
						}
			}
			System.out.println(str);
		}
	}

}
