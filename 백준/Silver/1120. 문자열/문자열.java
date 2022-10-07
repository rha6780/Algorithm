import java.util.Scanner;

public class Main {
	public static char[] B=new char[55];
	public static char[] A=new char[55];
	public static char[] temp=new char[55];
	public static int diff(){
		int xx=0;
		for(int i=0; i<B.length; i++){
			if(B[i]!=temp[i])xx++;
			}
		return xx;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		A=a.toCharArray();
		B=b.toCharArray();
		int Min=999;
		for(int i=0; i<=b.length()-a.length(); i++){
			temp=new char[55];
			temp=b.toCharArray();
			for(int j=0; j<a.length(); j++){
				temp[j+i]=A[j];
			}
			int d=diff();
			if(Min>=d){Min=d;}
		}
		System.out.println(Min);
	}

}