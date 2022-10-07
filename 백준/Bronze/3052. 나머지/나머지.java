import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] num=new int[10];
		boolean[] rest=new boolean[45];
		for(int i=0; i<10; i++) {
			num[i]=sc.nextInt();
			rest[num[i]%42]=true;
		}
		int count=0;
		for(int i=0; i<=42; i++) {
			if(rest[i]) {count++;}
		}
		System.out.print(count);
	}

}