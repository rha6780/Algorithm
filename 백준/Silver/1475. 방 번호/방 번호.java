import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); sc.close();
		int[] num=new int[10];int[] numcount=new int[10];
		for(int i=0; i<10; i++) {
			num[i]=i;
		}
		int t=10, res=0, max=-1;if(N==0)numcount[0]++;
		for(int j=0; 0<N ;j++) {
			res=N%t; N=N/10;
			for(int i=0; i<10; i++) {
				if(res==num[i]) 
					numcount[i]++; 
			}
		}int u=numcount[6]+numcount[9];
		numcount[6]=(u/2+u%2);
		for(int i=0; i<9; i++) {
			if(max<numcount[i]) {
				max=numcount[i];
				}
		}
		System.out.print(max);
	}
}
