import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt(), B=sc.nextInt();
		int count=1, sum=0;
		for(int i=1; i<=1000; i++) {
			for(int j=0; j<i; j++) {
				if(count>=A&&count<=B) {sum+=i;}
				count++;
			}
		}
		System.out.println(sum);
	}

}
