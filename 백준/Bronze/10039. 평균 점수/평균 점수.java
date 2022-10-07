import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i, mean=0;
		int [] score=new int[5];
		for(i=0; i<5;i++) {
			score[i]=sc.nextInt();
			if(score[i]<40)
				score[i]=40;
			mean+=score[i];
		}
		System.out.print(mean/5);
	}
}
