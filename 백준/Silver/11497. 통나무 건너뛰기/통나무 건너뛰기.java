import java.util.Scanner;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T, C,i, h,j;
		T=scan.nextInt();
		int []level=new int [T];
		for(i=0; i<T; i++) {
			C=scan.nextInt();int[] subtract=new int[C-2];int []N=new int[C];
			for(j=0 ;j<C;j++) { 
				N[j]=scan.nextInt();
			}
			Arrays.sort(N);
			for(h=0; h<C-2; h++) {
				subtract[h]=N[h+2]-N[h];
			}
			Arrays.sort(subtract);
			level[i]=subtract[C-3];
		}
		scan.close();
		for(i=0; i<T; i++)
		System.out.println(level[i]);
	}
}