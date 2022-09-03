import java.util.Scanner;
public class Main {
	public static long[][] spot=new long[4][2];
	public static int Area(long x1, long y1, long x2, long y2, long x3, long y3){
		long su=0;
		su=(((x1*y2)-(x2*y1))+((x2*y3)-(x3*y2))+((x3*y1)-(x1*y3)));
		if(su>0){
			return 1;
		}
		else return -1;
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
		if((a1*a2)<0&&(b1*b2)<0){
			System.out.println(1);
		}
		else
			System.out.println(0);
	}
}