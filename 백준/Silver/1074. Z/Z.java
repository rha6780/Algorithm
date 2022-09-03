import java.util.*;
public class Main {

	public static int[][] board;
	public static int Dp(int r, int c){
		if(r<2&&c<2){return board[r][c];}
		else{
			int a=Dp((r/2),(c/2))*4+Dp((r%2),c%2);
			return a;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); int r=sc.nextInt(); int c=sc.nextInt();
		board=new int[4][4];
		board[0][0]=0;board[0][1]=1;board[1][0]=2;board[1][1]=3;
		if(r<2&&c<2){	
		System.out.println(board[r][c]);
		}
		else{
			System.out.println(Dp(r, c));
			
		}
	}

}
