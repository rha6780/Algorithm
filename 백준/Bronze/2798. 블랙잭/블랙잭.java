import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		int[] num=new int[101];
		int CC=0, dummy=0, Min=99999999;
		for(int i=0; i<N; i++) {num[i]=sc.nextInt(); }
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int h=j+1; h<N; h++) {
					dummy=0;
					dummy=num[i]+num[j]+num[h];
					CC=M-dummy;
					if(CC>=0) {if(Min>CC) {Min=CC;}}
				}
			}
		}
		System.out.println(M-Min);

	}

}
