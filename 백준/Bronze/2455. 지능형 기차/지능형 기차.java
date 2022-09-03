import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] people=new int[5];
		int[] take=new int[5];
		int Max=0, train=0;
		for(int i=0; i<4; i++) {
			people[i]=sc.nextInt();
			take[i]=sc.nextInt();
			train+=take[i]-people[i];
			if(Max<train)Max=train;
		}
		System.out.println(Max);
	}
}