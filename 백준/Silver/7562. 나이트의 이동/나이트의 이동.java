import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Main {
	public static boolean[][] visit; 
	public static int[][] level; 
	
	public static Queue<Integer> que1=new LinkedList<Integer>();
	public static void BFS(int v1, int v2, int d1, int d2, int a){
		que1.clear(); 
		
		visit=new boolean[a+1][a+1];
		level=new int[a+1][a+1];
		que1.add((v1*a)+v2);
	
		visit[v1][v2]=true; 
		level[v1][v2]=0;
		if(v1==d1&&v2==d2){System.out.println("0"); return;}
		while(!que1.isEmpty()){
			int p=que1.poll();
			int p1=p/a; int p2=p%a; 

			if(p1==d1&&p2==d2){System.out.println(level[p1][p2]); break;}
			else{
			if(p1+2<a&& p2+1<a&&visit[p1+2][p2+1]==false){
				que1.add(((p1+2)*a)+p2+1); visit[p1+2][p2+1]=true;
				level[p1+2][p2+1]=level[p1][p2]+1;
			}
			if(p1+1<a&& p2+2<a&&visit[p1+1][p2+2]==false){
				que1.add(a*(p1+1)+p2+2);  visit[p1+1][p2+2]=true;
				level[p1+1][p2+2]=level[p1][p2]+1;
			}
			if(p1-2>=0&& p2+1<a&&visit[p1-2][p2+1]==false){
				que1.add(a*(p1-2)+p2+1); visit[p1-2][p2+1]=true;
				level[p1-2][p2+1]=level[p1][p2]+1;
			}
			if(p1-1>=0&& p2+2<a&&visit[p1-1][p2+2]==false){
				que1.add(a*(p1-1)+p2+2); visit[p1-1][p2+2]=true;
				level[p1-1][p2+2]=level[p1][p2]+1;
			}
			if(p1-2>=0&& p2-1>=0&&visit[p1-2][p2-1]==false){
				que1.add(a*(p1-2)+p2-1);  visit[p1-2][p2-1]=true;
				level[p1-2][p2-1]=level[p1][p2]+1;
			}
			if(p1-1>=0&& p2-2>=0&&visit[p1-1][p2-2]==false){
				que1.add(a*(p1-1)+p2-2); visit[p1-1][p2-2]=true;
				level[p1-1][p2-2]=level[p1][p2]+1;
			}
			if(p1+2<a&& p2-1>=0&&visit[p1+2][p2-1]==false){
				que1.add(a*(p1+2)+p2-1); visit[p1+2][p2-1]=true;
				level[p1+2][p2-1]=level[p1][p2]+1;
			}
			if(p1+1<a&& p2-2>=0&&visit[p1+1][p2-2]==false){
				que1.add(a*(p1+1)+p2-2);  visit[p1+1][p2-2]=true;
				level[p1+1][p2-2]=level[p1][p2]+1;
			}
			}
		}
		que1.clear(); 
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0; i<T; i++){
			int a=sc.nextInt(); 
			
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int d1=sc.nextInt();
			int d2=sc.nextInt();
			BFS(v1, v2, d1, d2, a);
		}
		sc.close();
	}

}
