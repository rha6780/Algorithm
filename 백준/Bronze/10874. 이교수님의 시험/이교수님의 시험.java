import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[][] answer=new int[N][11];
		int[] retry=new int[N];
		for(int i=0; i<N; i++) {
			int count=0;
			for(int j=1; j<=10; j++) {
				answer[i][j]=sc.nextInt();
				if(answer[i][j]==((j-1)%5)+1) {
					count++;
				}
				}
			if(count==10) {retry[i]=1;}
		}
		
		for(int i=0; i<N; i++) {
			if(retry[i]==1) {System.out.println(i+1);}
		}
		

	}

}
