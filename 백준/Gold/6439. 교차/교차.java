import java.util.Scanner;
public class Main {
	
	public static int Area(int x1, int y1, int x2, int y2, int x3, int y3) {
		long sum=0;
		sum=((x1*y2)-(x2*y1)+(x2*y3)-(x3*y2)+(x3*y1)-(x1*y3));
		if(sum>0) return 1;
		else if(sum==0) return 0;
		else return -1;
	}
	public static void isconnect(int x1, int y1, int x2, int y2, int xx, int yy, int x, int y) {
		int a1=Area(x1, y1, x2, y2, xx, yy), a2=Area(x1, y1, x2, y2, xx, y),//왼쪽 선
				aa1=Area(xx, yy, xx, y, x1, y1), aa2=Area(xx, yy, xx, y, x2, y2);
		int b1=Area(x1, y1, x2, y2, xx, yy), b2=Area(x1, y1, x2, y2, x, yy),
				bb1=Area(xx, yy, x, yy, x1, y1), bb2=Area(xx, yy, x, yy, x2, y2);//위쪽 선
		int c1=Area(x1, y1, x2, y2, x, yy), c2=Area(x1, y1, x2, y2, x, y),
				cc1=Area(x, yy, x, y, x1, y1), cc2=Area(x, yy, x, y, x2, y2);//오른쪽 선
		int d1=Area(x1, y1, x2, y2, xx, y), d2=Area(x1, y1, x2, y2, x, y),
				dd1=Area(xx, y, x, y, x1, y1), dd2=Area(xx, y, x, y, x2, y2);//아랫 선
		if(a1*a2==0&&aa1*aa2==0) {if(x1==x2&&x1==xx&&Math.max(y1, y2)<=yy&&Math.max(y1, y2)>=y) {System.out.println("T");}
		else System.out.println("F");return;}
		else if((a1*a2)<=0&&(aa1*aa2)<=0) {System.out.println("T");return;}
		if(b1*b2==0&&bb1*bb2==0) {if(y1==y2&&y1==yy&&Math.max(x1, x2)<=x&&Math.max(x1, x2)>=xx) {System.out.println("T");}
		else System.out.println("F"); return;}
		else if((b1*b2)<=0&&(bb1*bb2)<=0) {System.out.println("T");return;}
		if(c1*c2==0&&cc1*cc2==0) {if(x1==x2&&x2==x&&Math.max(y1, y2)<=yy&&Math.max(y1, y2)>=y) {System.out.println("T");}
		else System.out.println("F"); return;}
		else if((c1*c2)<=0&&(cc1*cc2)<=0) {System.out.println("T");return;}
		if(d1*d2==0&&dd1*dd2==0) {if(y1==y2&&y1==y&&Math.max(x1, x2)<=x&&Math.max(x1, x2)>=xx) {System.out.println("T");}
		else System.out.println("F"); return;}
		else if((d1*d2)<=0&&(dd1*dd2)<=0) {System.out.println("T");return;}
		System.out.println("F");
	}
	public static void sp(int x1, int y1, int x2, int y2, int xx1, int yy1, int xx2, int yy2) {
		int xx=Math.max(xx1, xx2), xs=Math.min(xx1, xx2);//사각형 왼쪽 오른쪽구분
		int yy=Math.max(yy1, yy2), ys=Math.min(yy1, yy2);//사각형 위 아래 구분
		if(Math.max(x1, x2)<=xx&&Math.min(x1, x2)>=xs&&Math.max(y1, y2)<=yy&&Math.min(y1, y2)>=ys) {
			System.out.println("T"); return;
		}
		else {
		isconnect(x1, y1, x2, y2, xs, yy, xx, ys);}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++) {
			int xs=sc.nextInt(), ys=sc.nextInt(), xe=sc.nextInt(), ye=sc.nextInt(),
					xl=sc.nextInt(), yt=sc.nextInt(),xr=sc.nextInt(), yb=sc.nextInt();
			sp(xs, ys, xe, ye, xl, yt, xr, yb);
		}
	}

}