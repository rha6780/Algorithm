import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int N, i, j, k;
		
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		char [] win= new char[N];
		
		for(i=0; i<N; i++) {
			int a1, b1;
			int[] cnta=new int [4];
			int[] cntb=new int [4];
			int[] a=new int [100], b= new int [100];
				a1=scan.nextInt();
				for(k=0; k<a1; k++) {
				a[k]=scan.nextInt();
				cnta[a[k]-1]++;
				}
				b1=scan.nextInt();
				for(k=0; k<b1; k++) {
				b[k]=scan.nextInt();
				cntb[b[k]-1]++;
				}
				
				for(j=3; j>=0; j--) {
					if(cnta[0]==cntb[0]) {
						win[i]='D';}
					
				if(cnta[j]!=cntb[j]) {
					if(cnta[j]>cntb[j]) {
					win[i]='A';break;}
		
					else win[i]='B';break;
				}
				else continue;
				}
		}
		for(i=0; i<N; i++) {
			System.out.println(win[i]);
		}
	}
}