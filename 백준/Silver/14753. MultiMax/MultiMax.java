import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int N;
		int cor, max;
		Scanner scan=new Scanner(System.in);
		N= scan.nextInt();
		int []card=new int [N];
		for(int i=0; i<N; i++) {
			card[i]=scan.nextInt();
		}
		Arrays.sort(card);
		
		max=card[0]*card[1];
		
		cor=card[N-1]*card[N-2];
		if(max<cor) max=cor;
		
		cor=card[0]*card[1]*card[N-1];
		if(max<cor) max=cor;
		
		cor=card[N-3]*card[N-2]*card[N-1];
		if(max<cor) max=cor;
			System.out.print(max);

	}

}