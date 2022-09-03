import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt();
		int[] bc=new int[3];
		int t6=a*b;
		int Hun=10;
		for(int i=0; i<3; i++) {
			bc[i]=b%Hun;
			b/=Hun;
		}
		int t3=a*bc[0], t4=a*bc[1], t5=a*bc[2];
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
		System.out.println(t6);
		sc.close();
	}

}
