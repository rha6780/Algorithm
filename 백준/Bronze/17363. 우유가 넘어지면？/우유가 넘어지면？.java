import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		char[][] milk=new char[N][M];
		char[][] dkdi=new char[M][N];
		for(int i=0; i<N; i++){
			String s=sc.next();
			milk[i]=s.toCharArray();
		}
		sc.close();
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(milk[i][j]=='.'){dkdi[j][i]='.';}
				else if(milk[i][j]=='O'){dkdi[j][i]='O';}
				else if(milk[i][j]=='-'){dkdi[j][i]='|';}
				else if(milk[i][j]=='|'){dkdi[j][i]='-';}
				else if(milk[i][j]=='/'){dkdi[j][i]='\\';}
				else if(milk[i][j]=='\\'){dkdi[j][i]='/';}
				else if(milk[i][j]=='^'){dkdi[j][i]='<';}
				else if(milk[i][j]=='<'){dkdi[j][i]='v';}
				else if(milk[i][j]=='v'){dkdi[j][i]='>';}
				else if(milk[i][j]=='>'){dkdi[j][i]='^';}
				
			}
		
		}
		for(int i=M-1; i>=0; i--){
			for(int j=0; j<N; j++){
				System.out.print(dkdi[i][j]);
			}
			System.out.println();
		}

	}

}
