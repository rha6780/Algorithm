import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		boolean[] sosu=new boolean[10000001];
		char[] arr=s.toCharArray();
		sosu[1]=true; sosu[2]=true;
		
		for(int i=3; i<=2000; i++) {
			boolean a=true;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					a=false; break;
				}
			}
			if(a) {sosu[i]=true;}
		}
		int sum=0;
		for(int i=0; i<s.length(); i++) {
			if(arr[i]>='a'&&arr[i]<='z') {
				sum+=arr[i]-'a'+1;
			}
			else if(arr[i]>='A'&&arr[i]<='Z') {
				sum+=arr[i]-'A'+27;
			}
		}
		if(sosu[sum]) {System.out.println("It is a prime word.");}
		else {
			System.out.println("It is not a prime word.");
		}

	}

}
