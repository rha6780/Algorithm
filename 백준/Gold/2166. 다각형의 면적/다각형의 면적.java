import java.util.*;
public class Main {
	
	public static long[][] spot;
	public static double result=0;
	public static void Area(long x1, long y1, long x2, long y2, long x3, long y3){
		long sum=0;
		sum=((x1*y2)-(x2*y1))+((x2*y3)-(x3*y2))+((x3*y1)-(x1*y3));
		result+=((double)sum);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		spot=new long[N][2];
		for(int i=0; i<N; i++){
			spot[i][0]=sc.nextLong();
			spot[i][1]=sc.nextLong();
		}
		
			for(int j=1; j<N-1; j++)
				Area(spot[0][0],spot[0][1],spot[j][0],spot[j][1],spot[j+1][0],spot[j+1][1]);
				
		System.out.println(String.format("%.1f",(double) Math.round(Math.abs(result/2)*10)/10));

	}

}
