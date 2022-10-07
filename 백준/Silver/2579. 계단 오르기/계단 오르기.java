import java.util.*;
public class Main {

	public static int[][] D;
	public static int[][] dp;
	public static int N;
	public static int[] stair;
	public static boolean[][] visit;
	public static int Dp(int k, int n){
		visit[n][k]=true;
		if(k==0){
			D[n][k]+=stair[n-2]+stair[n-1];
			if(n-3>0){
			int t1=D[n-3][0], t2=D[n-3][2];
			if(visit[n-3][0]==false){t1=Dp(0,n-3);}
			if(visit[n-3][2]==false){t2=Dp(2,n-3);}
			
			D[n][k]+=Math.max(t1, t2);}
		}
		if(k==1){
			D[n][k]+=stair[n]+stair[n-2];
			if(n-3>0){
			int t1=D[n-3][0], t2=D[n-3][2], t3=D[n-3][1];
			if(visit[n-3][0]==false){t1=Dp(0,n-3);}
			if(visit[n-3][2]==false){t2=Dp(2,n-3);}
			if(visit[n-3][1]==false){t3=Dp(1,n-3);}
			int aa=Math.max(t1, t3);
			
			D[n][k]+=Math.max(aa, t2);}
		}
		if(k==2){
			D[n][k]+=stair[n-1];
			if(n-3>0){
			int t1=D[n-3][1], t2=D[n-3][3];
			if(visit[n-3][1]==false){t1=Dp(1,n-3);}
			if(visit[n-3][3]==false){t2=Dp(3,n-3);}
			
			D[n][k]+=Math.max(t1, t2);}
		}
		if(k==3){
			D[n][k]+=stair[n]+stair[n-1];
			if(n-3>0){
			int t1=D[n-3][1], t2=D[n-3][2];
			if(visit[n-3][1]==false){t1=Dp(1,n-3);}
			if(visit[n-3][3]==false){t2=Dp(3,n-3);}
			
			D[n][k]+=Math.max(t1, t2);}
		}
		System.out.println(n+" "+k+"번째 "+D[n][k]);
		
		return D[n][k];

	}
	public static int go(int n, int k){// k는 다음 계단을 밟을지 선택하는 플래그로 생각
		int res=0;
		if(n>=N) return Integer.MIN_VALUE;//마지막 계단을 밟지 못할때
		if(n==N-1) return stair[n]; //마지막 계단
		if(dp[n][k]!=-1){return dp[n][k];}
		if(k==0) res=stair[n]+go(n+2,1); //다음계단 건너뜀
		else{
			int t1=go(n+1,0);//연속 3계단을 밟지는 못하기때문..
			int t2=go(n+2,1);
			if(t1>=t2)res=stair[n]+t1;
			else res=stair[n]+t2;
			dp[n][k]=res;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		stair=new int[N+3];
		D=new int[N+1][4];
		dp=new int[N+1][2];
		visit=new boolean[N+1][4];
		for(int i=0; i<N; i++){
			stair[i]=sc.nextInt();
			dp[i][0]=-1; dp[i][1]=-1;
		}
		/*D[N][1]=Dp(1,N);
		D[N][3]=Dp(3,N);
		
		System.out.println(Math.max(D[N][1], D[N][3]));*/
		
		int t1=go(0,1); //첫계단을 밟을때
		int t2=go(1,1); //첫계단을 밟지 않을때
		System.out.println(Math.max(t1,t2));
	}

}
