import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;	
public class Main {
	public static int[][] trg=new int[502][502];
	public static int[][] sum=new int[502][502];
	public static Queue<Integer> que=new LinkedList<Integer>();
	public static int last=0;
	public static int Dp(int n){
		int m=0, hang=2;//m은 현재 위치 hang은 현재 행
		que.add(0);m=0;
		while(!que.isEmpty()){
			int t=que.poll();
			if(t>0&&t<hang){sum[hang][t]=Math.max(sum[hang-1][t-1], sum[hang-1][t]); sum[hang][t]+=trg[hang][t];}//왼쪽오른쪽
			else if(t==0){sum[hang][t]=sum[hang-1][t]+trg[hang][t];}
			else if(t==n-1){sum[hang][t]=sum[hang-1][t-1]+trg[hang][t];}
			if(sum[hang][t]>m){m=sum[hang][t];}
			if(t==hang){t=0;hang++; que.add(0);}
			else {que.add(t+1);if(n<hang)break;}
		}
		return m;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for(int i=1; i<=N; i++){//i=행의 번호
			for(int j=0; j<i; j++){//인덱싱
			trg[i][j]=sc.nextInt();
			}
		}
		sum[1][0]=trg[1][0];
		
		int Max=Dp(N);
		
		System.out.println(Max);
	}

}