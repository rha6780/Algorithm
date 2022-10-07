import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
	public static int repaint(char[][] c) {
		//W 시작
		int count1=0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j)%2==1) {
					if(c[i][j]!='B') {count1++;}
				}
				else if((i+j)%2==0) {
					if(c[i][j]!='W') {count1++;}
				}
			}
		}
		int count2=0;
		//B 시작
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if((i+j)%2==1) {
					if(c[i][j]!='W') {count2++;}
				}
				else if((i+j)%2==0) {
					if(c[i][j]!='B') {count2++;}
				}
			}
		}
		if(count1<count2) {return count1;}
		else {return count2;}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		StringTokenizer st=new StringTokenizer(s);
		int N=Integer.parseInt(st.nextToken()); int M=Integer.parseInt(st.nextToken());
		char[][] board=new char[N][M];
		int r=N-8; int c=M-8;
		for(int i=0; i<N; i++) {
			String ss=br.readLine();
			board[i]=ss.toCharArray();
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0; i<=r; i++) {
			for(int j=0; j<=c; j++) {
				char[][] cut=new char[8][8];
				for(int h=i; h<i+8; h++) {
					for(int k=j; k<j+8; k++) {
						cut[h-i][k-j]=board[h][k];
					}
				}
				int cc=repaint(cut);
				if(cc<min) {min=cc;}
			}
		}
		System.out.println(min);
	}

}
