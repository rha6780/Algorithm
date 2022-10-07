import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {
		int[] num=new int[9];
		Scanner sc=new Scanner(System.in);
		int Max=0; int ind=0;
		for(int i=0; i<9; i++) {
			num[i]=sc.nextInt();
			if(Max<num[i]) {Max=num[i]; ind=i+1;}
		}
		System.out.println(Max);
		System.out.println(ind);
		sc.close();
	}

}
