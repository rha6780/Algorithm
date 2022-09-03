import java.util.*;
public class Main {

	public static int[][] d=new int[600][600];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		d=new int[N+1][N+1];
		for(int i=0; i<N+1; i++){
			for(int j=0; j<N+1; j++){
				d[i][j]=500;
			}
		}
		for(int i=0; i<M; i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			d[a][b]=1;
		}
		for(int h=1; h<N+1; h++){
			for(int i=1; i<N+1; i++){
				for(int j=1; j<N+1; j++){
					if(d[i][j]>d[i][h]+d[h][j]){
						d[i][j]=d[i][h]+d[h][j];
					}
				}
			}
		}
		int count=0;
		int[][] cc=new int[N+1][2];
		for(int j=1; j<N+1; j++){
			for(int i=1; i<N+1; i++){
				if(d[i][j]!=500){
					cc[i][0]++;
				}
				if(d[i][j]==500&&d[j][i]!=500){
					cc[i][1]++;
				}
			}
		}
		for(int i=1; i<N+1; i++){
			//System.out.println(i+" "+cc[i][0]+" "+cc[i][1]);
			if(cc[i][0]+cc[i][1]==N-1){
				count++;
			}
		}
		System.out.println(count);
	}

}
