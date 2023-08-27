import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int count=0;
		boolean ispo=false;
		if(n%5==0) {count=n/5;}
		else if(n%5==1) {count=n/5+1;}
		else if(n%5==2&&n>=12) {count=n/5+2;}
		else if(n%5==3) {count=n/5+1;}
		else if(n%5==4&&n>=9) {count=n/5+2;}
		else {count=-1;}
		System.out.println(count);

	}

}
