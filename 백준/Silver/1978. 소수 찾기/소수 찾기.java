import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int N, count=0,sub=0;
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		int []a=new int [N];
		for(int i=0; i<N; i++)
			a[i]=scan.nextInt();
		
		for(int i=0; i<N; i++) {
			sub=0;
			if(a[i]==2)count++;
			else {
			for(int j=2; j<a[i]; j++) {
				 if((a[i]%j)==0) sub++;
			}
			if((sub==0)&&(a[i]!=1))
				count++;
			}
		}
		System.out.print(count);
	}

}
