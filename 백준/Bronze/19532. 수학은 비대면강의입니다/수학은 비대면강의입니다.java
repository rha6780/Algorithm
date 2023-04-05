import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(); int b=sc.nextInt(); int c=sc.nextInt(); int d=sc.nextInt();
		int e=sc.nextInt(); int f=sc.nextInt();
		int x=0, y=0;
		
		if(((a*e)!=(d*b))) {
			y=((a*f)-(d*c))/((a*e)-(d*b));
			if(a!=0) {
				x=(c-(b*y))/a;}
			else if(a==0&&d!=0) {
				x=(f-e*y)/d;
			}
			}
		else {
			y=0;
			if(a!=0)x=c/a;
			else if(a==0&&d!=0) {
				x=f/d;
			}
		}
		
		
		System.out.println(x+" "+y);
	}

}
