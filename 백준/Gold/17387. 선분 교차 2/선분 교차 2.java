import java.util.Scanner;
public class Main {
	public static long[][] spot=new long[4][2];
	public static int Area(long x1, long y1, long x2, long y2, long x3, long y3){
		long su=0;
		su=(((x1*y2)-(x2*y1))+((x2*y3)-(x3*y2))+((x3*y1)-(x1*y3)));
		if(su>0){
			return 1;
		}
		else if(su==0) return 0;
		else return -1;
	}
	public static void angle(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
		float a1=0, a2=0;
		if(x2-x1==0){a1=0;} else{if(x2>x1)a1=(float) ((y2-y1)/(x2-x1)); else a1=(float) ((y1-y2)/(x1-x2));}
		if(x3-x4==0){a2=0;} else{if(x3>x4)a2=(float) ((y3-y4)/(x3-x4)); else a2=(float) ((y4-y3)/(x4-x3));}

		if(a1==a2){//기울기가 같은경우
		if(Math.max(x1, x2)<Math.min(x3, x4)){System.out.println(0);return;}
		if(Math.max(x3, x4)<Math.min(x1, x2)){System.out.println(0);return;}
		if(Math.max(y1, y2)<Math.min(y3, y4)){System.out.println(0);return;}
		if(Math.max(y3, y4)<Math.min(y1, y2)){System.out.println(0);return;}
			
		else System.out.println(1);}

		else System.out.println(1);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=0; i<4; i++){
			spot[i][0]=sc.nextLong();
			spot[i][1]=sc.nextLong();
		}
		sc.close();
		
		long a1=Area(spot[0][0], spot[0][1], spot[1][0],spot[1][1], spot[2][0], spot[2][1]);
		long a2=Area(spot[0][0], spot[0][1], spot[1][0],spot[1][1], spot[3][0], spot[3][1]);
		long b1=Area(spot[2][0], spot[2][1], spot[3][0],spot[3][1], spot[0][0], spot[0][1]);
		long b2=Area(spot[2][0], spot[2][1], spot[3][0],spot[3][1], spot[1][0], spot[1][1]);
		if((a1*a2)<=0&&(b1*b2)<=0){
			angle(spot[0][0], spot[0][1], spot[1][0],spot[1][1], spot[2][0], spot[2][1], spot[3][0], spot[3][1]);
		}
		else
			System.out.println(0);
	}
}