import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static int[][] move=new int[200001][3];
	public static int[] dis=new int[200001];
	public static boolean[] visit=new boolean[200001];
	public static int Min=900001;
	public static Queue<Integer> que=new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int X=sc.nextInt();
		int K=sc.nextInt();
		if(X==K)Min=0;
		else {
		que.add(X);
		visit[X]=true;
		while(!que.isEmpty()){
			int q=que.poll();
			for(int i=0; i<3; i++) {
				if(i==0) {if((q*2)<=200000) move[q][i]=(q*2); else break;}
				else if(i==1) {if((q+1)<=200000)move[q][i]=(q+1);else break;}
				else {if(q-1>=0)move[q][i]=(q-1); else break;}
				if(visit[move[q][i]]==false) {
					que.add(move[q][i]);
					dis[move[q][i]]=dis[q]+1;
					
					visit[move[q][i]]=true;
				}
				else if(visit[move[q][i]]==true) {
					if(dis[move[q][i]]>(dis[q]+1)) {
						dis[move[q][i]]=dis[q]+1;
					}
				}
				
				if(move[q][i]==K) {if(Min>dis[K]) {Min=dis[K]; }}
			}
		}
		}
		System.out.println(Min);
	}

}