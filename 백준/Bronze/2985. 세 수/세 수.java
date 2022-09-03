import java.util.Scanner;
public class Main {

	public static String solve(int e, int v, int j) {
		String f = null;
	if(j!=0) {
		if(e-v==j) {
			f="-";
		}
		else if(e+v==j) {
			f="+";
			
		}
		else if(e*v==j) {
			f="*";

		}
		else if(e/v==j) {
			f="/";
		}
		else {
			f=null;
		}
	
	}
	else if(j==0) {
		if((e==0)||(v==0)) {
		    f="*";
		}
		else if((e==v)&&(e!=0)) {
			f="-";
		}
		else if(e!=v) {
			f="/";
		}
		}
		return f;
	
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		String word=null;
		word=solve(a,b,c);
		
		if(word!=null) {
			System.out.print(a+word+b+"="+c);
		}
		else {
		word=solve(b,c,a);
		System.out.println(a+"="+b+word+c);
		}
		
	}

}