import java.util.Scanner;
public class Main{
	public static int same(int e, int j) {
		int f=0;
				if((e-j)<0) {
					f=-(e-j);
				}
				else {
					f=e-j;
				}
			return f;
	}
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int a=1, b=1,c=0;
		while((a!=0)&&(b!=0)) {
			a=scanner.nextInt();
			b=scanner.nextInt();
			if(a>b)
				c=b-same(a,b);
			else
				c=a-same(a,b);
			if((a==0)&&(b==0))
				break;
			System.out.println(c);
		}
	}

}