import java.util.Scanner;
public class Main{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		
		int n=0;
		
		int team=0;
		if((N/2)<M) {team=(N/2); n=M-team;}
		else {team=M; n=N-(team*2);}
		
		while(true) {
			if(K!=0) {
				if(K>n) { K-=n;
				n=0;
				team--;
				K-=3;
				}
				else break;
			}
			else break;
		}
		
		System.out.println(team);
		
	}

}