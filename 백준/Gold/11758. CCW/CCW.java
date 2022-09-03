import java.util.*;
public class Main {
	public static int Area(int x1, int y1, int x2, int y2, int x3, int y3){
		long sum=0;
		sum=(((x1*y2)-(x2*y1))+((x2*y3)-(x3*y2))+((x3*y1)-(x1*y3)));
		if(sum>0) return 1;
		else if(sum==0) return 0;
		else return -1;
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt(); int y1=sc.nextInt();
		int x2=sc.nextInt(); int y2=sc.nextInt();
		int x3=sc.nextInt(); int y3=sc.nextInt();
		System.out.println(Area(x1,y1,x2,y2,x3,y3));

	}

}
