import java.util.*;
public class Main{
	public static int[][] paper;
	public static int w=0, blue=0;
	public static void search(int a, int a1, int b, int b1) {//a=첫점의 y, a1= 끝점의 y, b=첫점의 x,b1=끝점의 x
		int one=0, zero=0;
		int len=a1-a;
		int count=len*len;
		if(len==1) {
			if(paper[a][b]==1) {blue++;}
			else {w++;}
			return;
		}else {
		for(int i=a; i<a1; i++) {
			for(int j=b; j<b1; j++) {
				if(paper[i][j]==1) {one++;}
				else {zero++;}
			}
		}
		if(one==count) {blue++; return;}
		else if(zero==count) {w++;return;}
		else {
			search(a,a+len/2,b,b+len/2);
			search(a,a+len/2,b+len/2,b1);
			search(a+len/2,a1,b,b+len/2);
			search(a+len/2,a1,b+len/2,b1);
			return;
		}}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		paper=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j]=sc.nextInt();
			}
		}

		search(0,N,0,N);
		System.out.println(w);
		System.out.println(blue);
	}

}
