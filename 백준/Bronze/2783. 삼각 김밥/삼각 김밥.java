import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double s25x=sc.nextInt(),s25y=sc.nextInt();
		s25x*=(1000/s25y);
		int T=sc.nextInt();
		double[] arx=new double [T];
		double[] ary=new double [T];
		
		for(int i=0; i<T; i++) {
			arx[i]=sc.nextInt(); ary[i]=sc.nextInt(); 
			
		}sc.close();
		for(int i=0; i<T; i++) {
			arx[i]*=(1000/ary[i]);
			
			if(arx[i]<=s25x){s25x=arx[i];}
			
		}
		System.out.print(s25x);
	}

}