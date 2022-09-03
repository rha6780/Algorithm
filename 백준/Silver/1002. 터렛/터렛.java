import java.util.Scanner;
public class Main {

	public static int distance(int x1, int y1, int x2, int y2) {
		int X=Math.abs(x1-x2);
		int Y=Math.abs(y1-y2);
		int C=(X*X)+(Y*Y);
		return C;
	}
	public static void calcul(int x1, int y1, int x2, int y2, int r1, int r2 ) {
		int d=distance(x1,y1,x2,y2);
		float dd=(float)Math.sqrt(d);
		if(x1==x2&&y1==y2) {if(r1==r2) {System.out.println(-1);} else System.out.println(0); return;}//원이 일치
		else if(d==((r1+r2)*(r1+r2))) {System.out.println(1);}//원이 외접할때
		else if(d>((r1+r2)*(r1+r2))) {System.out.println(0);}//중심이 외부에 있고 원이 만나지 않을때
		else if(d<((r1+r2)*(r1+r2))) {
			if(dd+r2<r1) {System.out.println(0);}
			else if(dd+r1<r2) {System.out.println(0);}
			else if(dd+r1==r2) System.out.println(1);//내접
			else if(dd+r2==r1) System.out.println(1);//내접
			else System.out.println(2);
		}

		else System.out.println(2);
		}
		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int r1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			int r2=sc.nextInt();
			calcul(x1, y1, x2, y2, r1, r2);
		}
	}
}