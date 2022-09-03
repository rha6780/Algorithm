import java.util.*;
import java.io.*;

public class Main {
	public static int[] coding=new int[1000];
	public static int[][] tmp=new int[1000][1000];
	public static int[][] re=new int[1000][1000];
	public static int N=0;
	
	public static int DP(int a, int b) {
		if(re[a][b]!=0) {return re[a][b];} //더이상 탐색x
		if(b-a==1) {// 옆에 있는 것이라면 한번 연결해 본다.
			tmp[a][b]=Math.max(coding[a], coding[b]);
			if(coding[a]<coding[b]) {
				re[a][b]=coding[b]-coding[a];
			}
			else {re[a][b]=coding[a]-coding[b];}
		}
		if(b<a) {return Integer.MAX_VALUE;} //탐색 범위 초과시 최댓값
		else if(b==a) {tmp[a][b]=coding[a]; return re[a][b]=0;}
        //같은 거라면 그냥 0
		
		int ind=Integer.MAX_VALUE; //결과값 담을 것
        //for 문으로 사이에 조합을 생각한다.
		for(int i=a; i<b; i++) {
			int r1=DP(a, i)+DP(i+1, b)+(int)Math.abs(tmp[a][i]-tmp[i+1][b]);
			if(ind>r1) {
				ind=r1; //최대를 담고 그곳에 최대 수치를 담는다.
				tmp[a][b]=Math.max(tmp[a][i], tmp[i+1][b]);
			}
		}
		return re[a][b]=ind;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		coding=new int[N];
		tmp=new int[N][N];
		re=new int[N][N];
		for(int i=0; i<N; i++) {
			coding[i]=Integer.parseInt(br.readLine());
		}
		br.close();

		System.out.println(DP(0, N-1));

		
	}

}
