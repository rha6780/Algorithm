import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int M=sc.nextInt();
		char[][] floor=new char[N][M];
		for(int i=0; i<N; i++){
			String s=sc.next();
			floor[i]=s.toCharArray();
		}
		int result=0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(j==0){result++;}
				else if(j>0){
					if(floor[i][j]==floor[i][j-1]&&floor[i][j]=='-'){
					}
					else{result++;}
					
				}
				if(i>0){
					if(floor[i-1][j]==floor[i][j]&&floor[i][j]=='|'){
						result--;
					}
				}
			}
		}

		System.out.println(result);
	}

}
