import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int L=sc.nextInt(), P=sc.nextInt();
		int people=L*P;
		int[] news=new int[5];
		int[] deduct=new int[5];
		for(int i=0; i<5; i++){
			news[i]=sc.nextInt();
			deduct[i]=news[i]-people;
		}
		sc.close();
		for(int i=0; i<5; i++){System.out.print(deduct[i]+" ");}
	}

}
