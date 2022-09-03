import java.util.Arrays;
import java.util.Scanner;
public class Main {
	public static double []team=new double[1001];
	public static int []scor=new int[1001];
	public static int []discor=new int[1001];

	public static double EX(int g) {
		double S=(double)scor[g]*scor[g];
		double A=(double)discor[g]*discor[g];
		double exs;
		if(S==0) exs=0;
		else
		exs=S/(S+A);
		return exs;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double min=Integer.MAX_VALUE;
		double max=Integer.MIN_VALUE;
		int []teams=new int [4];
		
		int N=sc.nextInt();
		for(int i=0; i<N; i++) {
			int n=sc.nextInt(); int m=sc.nextInt();
			team=new double[n];discor=new int[n];scor=new int[n];
			for(int j=0; j<m; j++){

					 teams=new int[4];
				for(int h=0; h<4; h++) {
					teams[h]=sc.nextInt();
				}
					scor[teams[0]-1]+=teams[2]; discor[teams[0]-1]+=teams[3];
					scor[teams[1]-1]+=teams[3]; discor[teams[1]-1]+=teams[2];
			}
			
			for(int j=0; j<n; j++) {
			team[j]=EX(j);
			}
			Arrays.sort(team);
			
			System.out.println((int)(team[n-1]*1000));
			System.out.println((int)(team[0]*1000));
		}

	}

}