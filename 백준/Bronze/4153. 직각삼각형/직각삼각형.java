import java.util.*;
public class Main {

	public static void judge(int a, int b, int c) {
		long o=(b*b)+(c*c);
		if(a==Math.sqrt(o)) {System.out.println("right");}
		else {
			System.out.println("wrong");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int a=sc.nextInt(); int b=sc.nextInt(); int c=sc.nextInt();
			if(a==0&&b==0&&c==0) {break;}
			else {
				int max=0; boolean aa=false, bb=false, cc=false;
				if(a>max) {max=a; aa=false; bb=true; cc=true;
					if(b>max) {max=b; aa=true; cc=true; bb=false;}
					if(c>max) {max=c; aa=true; bb=true; cc=false;}
				}
				
				if(aa==false) {
					judge(a,b,c);
				}
				else if(bb==false) {
					judge(b,c,a);
				}
				else {
					judge(c,a,b);
				}
			}
		}
	}

}
